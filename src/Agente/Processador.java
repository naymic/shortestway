package Agente;

import java.util.ArrayList;
import java.util.List;

import Estruturas.NoGrafo;
import Estruturas.VerticeGrafo;
import Utils.Geometria;

public class Processador {
	BancoDados bd;
	BancoConhecimento bc; //Banco de Conhecimento
	NoG inicio;
	NoG fim;
	Double distanceTotal;

	
	public Processador(Integer idEstadoInicio, Integer IdEstadofim){
		this.setBd(new BancoDados());
		this.setBc(BancoConhecimento.getBCInstance());
		
		NoG inicio = this.getBd().getNo(idEstadoInicio);
		NoG fim = this.getBd().getNo(IdEstadofim);
		
		this.setInicio(inicio);
		this.setFim(fim);
		
		distanceTotal=0.0;
	}


	public BancoConhecimento getBc() {
		return bc;
	}


	public void setBc(BancoConhecimento bc) {
		this.bc = bc;
	}


	public NoG getInicio() {
		return inicio;
	}


	public void setInicio(NoG inicio) {
		this.inicio = inicio;
	}


	public NoG getFim() {
		return fim;
	}


	public void setFim(NoG fim) {
		this.fim = fim;
	}


	public BancoDados getBd() {
		return bd;
	}


	public void setBd(BancoDados bd) {
		this.bd = bd;
	}
	

	
	public ArrayList<NoG> initProcurarCaminho(){
		NoG noAtual = this.getBd().getNo(this.getInicio().getId());
		
		Info i = new Info();
		i.setCaminho(null);
		i.setVisited(true);
		this.getBc().setInfo(noAtual, 0.0);
		this.getBc().getDistancia().put(noAtual, 0.0);
		
		this.procurarCaminho(noAtual);
		
		return this.getBc().getWay();
	}
	
	private boolean procurarCaminho(NoG noAtual){	
		NoG auxNo;
		
		this.getBc().getWay().add(noAtual);
		bc.setExpanded(noAtual);
		
		if(this.isNoFinal(noAtual)){
			return true;
		}
		
		//Get Vertices of this node
		List<Conexao> conexoes = BancoConhecimento.getBCInstance().getVertices(noAtual);
		
		//Set distances of every vertice of this Node
		this.setDistances(noAtual, conexoes);
		
		//Find the best Node
		auxNo = this.getBestNo(conexoes);	
		
		//Check if has a further way, if not -> go to the last Node
		if(auxNo == null){
			this.getBc().setDead(noAtual);
			auxNo = (NoG) this.getBc().getInfo(noAtual).getCaminho();
		
		//Check if its the inicial state and if have no more vertices
		}else if(auxNo == this.getInicio() &&  BancoConhecimento.getBCInstance().getVertices(auxNo).isEmpty()){
			return false;
		}else{
			//Adicionar distância 
			this.getBc().getDistancia().put(auxNo, this.getBc().getDistancia().get(noAtual)+this.getDistance(noAtual, auxNo));			
		}
		
		
		
		return procurarCaminho(auxNo);
		
	}
	
	public void setNoVisited(NoG e, Double distancia){
		this.getBc().setInfo(inicio, distancia);
		this.getBc().setVisited(inicio);
	}
	
	public void setNoExpandido(NoG e, Double distancia){
		this.getBc().setInfo(inicio, distancia);
		this.getBc().setExpanded(inicio);
	}
	
	private boolean isNoFinal(NoG no){
		return no.equals(this.getFim());
	}
	
	private List<Conexao> setDistances(NoG origem, List<Conexao> conexoes){
		NoGrafo<?> auxGrafo;
		
		for(VerticeGrafo<?> conexao : conexoes){
			auxGrafo = conexao.getDestino();
			//The info for this Destination exist allready
			if(this.getBc().getInfoMap().contains(conexao.getDestino())){
				
				this.getBc().overrideInfo((NoG) auxGrafo, this.getShorterWay(origem, (NoG) auxGrafo));
				
			}else{
				Info i = new Info();
				i.setVisited(true);
				i.setCaminho(origem);
				this.getBc().setInfo((NoG) auxGrafo, (this.getDistanceTotal() + this.getDistance(origem, (NoG) auxGrafo) + this.getDistance((NoG)auxGrafo, this.getFim())));
			}
		}
		
		return conexoes;
	}
	
	
	/**
	 * Get the best node of a Node
	 * @param conexoes
	 * @return
	 */
	private NoG getBestNo(List<Conexao> conexoes){
		NoG auxNo = null;
		NoG bestNo = null;
		
		if(conexoes.isEmpty())
			return null;
		
		
		for(Conexao conexao : conexoes){
			auxNo = (NoG)conexao.getDestino();
			if(bestNo == null || this.isNoFinal(auxNo) || (this.getBc().getDistance(auxNo) < this.getBc().getDistance(bestNo) && !this.getBc().isVisited(auxNo) )){
				bestNo = auxNo;
			}			
		}
		
		/*
		int rand = 0 + (int)(Math.random() * (conexoes.size()-1));
		auxNo = (NoG)conexoes.get(rand).getDestino();
	
		bestNo = auxNo;*/
		
		return bestNo;
	}
	
	/**
	 * Get the waz bewtwenn two Nodes
	 * @param origem
	 * @param destino
	 * @return
	 */
	private Double getDistance(NoG origem, NoG destino){
		return Geometria.getDistance(origem.getDado().getCoordX(), 
									destino.getDado().getCoordX(), 
									origem.getDado().getCoordY(), 
									destino.getDado().getCoordY(), 
									origem.getDado().getCoordZ(), 
									destino.getDado().getCoordZ());
	}
	
	private Double getDistanceTotal(){return this.distanceTotal;}
	
	/**
	 * Compares the way of two nodes
	 * @param origem
	 * @param destino
	 * @return
	 */
	private Info getShorterWay(NoG origem, NoG destino){
		Double newWay = this.getDistance(origem, destino);
		Double oldWay = this.getBc().getDistance(destino);
		Info i;
		i = this.getBc().getInfo(destino);
		
		if(newWay < oldWay){
			i.setCaminho(origem);
			i.setDistanciaTotal(this.getDistanceTotal() + this.getDistance(origem, destino));
		}
		
		return i;
		
	}
	
}
