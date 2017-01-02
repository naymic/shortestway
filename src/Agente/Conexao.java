package Agente;

import Estruturas.NoGrafo;
import Estruturas.VerticeGrafo;
import Utils.Geometria;

public class Conexao extends VerticeGrafo<Estado> {

	Double distance;
	
	public Conexao(NoGrafo<Estado> origem , NoGrafo<Estado> destino){
		super(destino);
		this.setDistance(origem, destino);
	}
	

	public Double getDistance() {
		return distance;
	}
	
	private void setDistance(NoGrafo<Estado> origem, NoGrafo<Estado> destino) {
		distance = Geometria.getDistance(
				origem.getDado().getCoordX(), 
				destino.getDado().getCoordX(),
				origem.getDado().getCoordY(), 
				destino.getDado().getCoordY(), 
				origem.getDado().getCoordZ(), 
				origem.getDado().getCoordZ());
	}
	
}
