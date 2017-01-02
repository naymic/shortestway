import java.util.List;

import Agente.NoG;
import Agente.Processador;


public class Main {


	public static void main(String args[]){

		//parameter 1 and 2 can both be set from 0 to 12
		Processador p = new Processador(12,0);
		List<NoG> caminho = p.initProcurarCaminho();

		Agente.View v = new Agente.View();
		v.printWay(caminho, p.getBc().getDistancia());

	}



}
