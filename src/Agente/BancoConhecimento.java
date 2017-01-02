package Agente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import Estruturas.NoGrafo;
import Estruturas.VerticeGrafo;

/**
 * Banco de Conhecimento
 * Salva dados durante a varredura do grafo
 * @author naymic
 *
 */
public class BancoConhecimento{
	
	//ArrayList<NoGrafo<Estado>> visitados; 
	//ArrayList<NoGrafo<Estado>> expandidos; 
	Hashtable<NoG, Info> info;
	ArrayList<NoG> way= new ArrayList<>();
	HashMap<NoG, Double> distancia= new HashMap<>();
	
	private static BancoConhecimento bc = null;
	
	public static BancoConhecimento getBCInstance(){
		if(bc == null){
			bc = new BancoConhecimento();
		}
		return bc;
	}
	
	
	private BancoConhecimento(){
		//visitados = new ArrayList<>();
		//expandidos = new ArrayList<>();
		info = new Hashtable<NoG, Info>();
	}
	
	public Hashtable<NoG, Info> getInfoMap(){
		return this.info;
	}
	
	public Info getInfo(NoG e){
		if(info.containsKey(e))
			return info.get(e);
		else
			return null;
		
	}
	
	public void setInfo(NoG destino, Double distanciaTotal){
		if(getInfo(destino) != null){
			this.updateInfo(destino, distanciaTotal);
		}else{
			this.newInfo(destino, distanciaTotal);
		}
	}
	
	public void  overrideInfo(NoG e, Info info){
		this.getInfoMap().replace(e, info);
	}
	
	public void newInfo(NoG e, Double distanciaTotal){
		Info i = new Info();
		i.setDistanciaTotal(distanciaTotal);
		info.put(e, i);
	}
	
	private void updateInfo(NoG e, Double distanciaTotal){
		Info i = info.get(e);
		i.setDistanciaTotal(distanciaTotal);
	}
	
	public Double getDistance(NoGrafo<Estado> e){
		
		if(info.containsKey(e)){
			return info.get(e).getDistanciaTotal();
		}else{
			return -1.0;	
		}
	}
	
	public boolean isVisited(NoG e){
		if(info == null)
			return false;
		
		return info.get(e).isVisited();
	}
	
	public boolean isExpanded(NoG e){
		return info.get(e).isExpanded();
	}
	
	public boolean isDead(NoG noGrafo){
		if(this.getInfo(noGrafo)==null)
			return false;
		
		return info.get(noGrafo).getDeadWay();
	}
	
	public void setVisited(NoG e){
		info.get(e).setVisited(true);
	}
	
	public void setExpanded(NoG e){
		info.get(e).setExpanded(true);
	}
	
	public void setDead(NoG e){
		info.get(e).setDeadWay(true);
	}
	
	public HashMap<NoG, Double> getDistancia(){
		return this.distancia;
	}
	
	
	public List<Conexao> getVertices(NoG n){
		List<VerticeGrafo<Estado>> vertices = n.getVertices();
		List<Conexao> l = new ArrayList<>();
		
		for(VerticeGrafo<Estado> vg : vertices){
			if(BancoConhecimento.getBCInstance().getInfo((NoG) vg.getDestino()) == null  && !BancoConhecimento.getBCInstance().isDead((NoG) vg.getDestino()))
				l.add((Conexao)vg);
		}
		
		return l;
	}


	public ArrayList<NoG> getWay() {
		return way;
	}
		
}
