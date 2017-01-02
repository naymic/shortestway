package Agente;
import java.util.HashMap;
import java.util.List;

import Agente.NoG;

public class View {
	
	public View(){
		
	}
	
	
	public static void main(String args[]){
		Processador p = new Processador(7,11);
		List<NoG> caminho = p.initProcurarCaminho();
		
		View v = new View();
		v.printWay(caminho, p.getBc().getDistancia());		
		
	}
	
	
	public void printNo(NoG n){
		System.out.println("Id: "+ n.getId());
		System.out.println("Nome: "+ n.getDado().getNome());
		System.out.println("Coord. X: "+ n.getDado().getCoordX() + " | Coord. Y:"+ n.getDado().getCoordY() + " | Coord. Z:"+  n.getDado().getCoordZ());
		
	}
	
	
	public void printWay(List<NoG> caminho, HashMap<NoG, Double> distancia){
		int i= 0;
		for(NoG n : caminho){
		System.out.println("\n*** Estado "+i+" ***");
			this.printNo(n);
			System.out.println("Distância percorrida: "+ Math.round(distancia.get(n)) +" Anos Luz");
			i++;
		}
	}
}
