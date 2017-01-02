package Estruturas;

import java.util.ArrayList;
import java.util.List;

public class NoGrafo<T>{
	
	int id;
	T dado;
	List<VerticeGrafo<T>> vertices;
	
	
	public NoGrafo(int id, T dado){
		this.id = id;
		vertices = new ArrayList<>();
		this.setDado(dado);
	}
	
	public List<VerticeGrafo<T>> getVertices(){
		return this.vertices;
	}
	
	public boolean existVertice(VerticeGrafo<T> vg){
		for(VerticeGrafo<T> atual : this.getVertices()){
			if(atual.equals(vg)){
				return true;
			}
		}
		
		return false;
	}
	
	
	public void addVertice(VerticeGrafo<T> vg){
		
		this.getVertices().add(vg);		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setDado(T dado){this.dado = dado;}
	public T getDado(){return this.dado;}

	public void setVertices(List<VerticeGrafo<T>> vertices) {
		this.vertices = vertices;
	}
	
}
