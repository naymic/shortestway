package Agente;

import Estruturas.NoGrafo;
import Estruturas.VerticeGrafo;

public class NoG extends NoGrafo<Estado>{

	public NoG(int id, Estado dado) {
		super(id, dado);
	}
	

	public void addConexao(Conexao c) throws Exception{
		if(!super.existVertice(c)){

			super.addVertice(c);
			
			if(!checkDestinoReturn(this, (NoG) c.getDestino())){
				addReturn(c);
			}
		}else{
			throw new Exception("Vertice com destino origem"+ this.getDado().getNome() +" e "+ c.getDestino().getDado().getNome() +" já existe");
		}

	}
	
	
	
	
	public boolean checkDestinoReturn(NoG origem, NoG destino){
		
		for(VerticeGrafo<Estado> vertice : destino.getVertices()){
			if(vertice.getDestino().getId() == origem.getId())
				return true;
		}
		
		return false;
		
	}
	
	protected void addReturn(Conexao vgOrigin){
		Conexao vgReturn = new Conexao(vgOrigin.getDestino(), this);
		
		vgOrigin.getDestino().addVertice(vgReturn);
	}

}
