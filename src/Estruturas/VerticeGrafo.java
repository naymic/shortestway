package Estruturas;

public class VerticeGrafo<T> {
	
	private NoGrafo<T> destino;
	
	
	public VerticeGrafo(NoGrafo<T> destino){
		this.setDestino(destino);
	}

	private void setDestino(NoGrafo<T> destino) {
		this.destino = destino;
	}

	public NoGrafo<T> getDestino(){return destino;}
	
	



	
}
