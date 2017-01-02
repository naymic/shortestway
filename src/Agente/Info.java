package Agente;


import Estruturas.NoGrafo;


public class Info {
	NoGrafo<Estado> origemNo;
	boolean visited;
	boolean expanded;
	boolean deadWay;
	
	public Info(){
		this.distanciaTotal = -1.0;
		this.visited = false;
		this.deadWay = false;
		this.expanded = true;
	}
	
	
	Double distanciaTotal;


	public Double getDistanciaTotal() {
		return distanciaTotal;
	}
	public void setDistanciaTotal(Double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
	public NoGrafo<Estado> getCaminho() {
		return origemNo;
	}
	public void setCaminho(NoGrafo<Estado> origemNo) {
		this.origemNo = origemNo;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	
	public void setDeadWay(boolean dead){
		this.deadWay = dead;
	}
	
	public boolean getDeadWay(){
		return this.deadWay;
		}


}

