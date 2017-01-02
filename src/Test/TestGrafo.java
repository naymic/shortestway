package Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Agente.BancoConhecimento;
import Agente.BancoDados;
import Agente.Conexao;
import Agente.NoG;
import Agente.Processador;
import Agente.View;


public class TestGrafo{

	@Test
	public void testVertice() {
		BancoDados bd = new BancoDados();
		BancoConhecimento bc = BancoConhecimento.getBCInstance();
		
		NoG ng = bd.getNo(0);
		NoG ng1 = bd.getNo(2);
		
		Conexao conex = new Conexao(ng, ng1);		
		try {
			ng.addConexao(conex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(Math.round(860), Math.round(conex.getDistance()));
		
		assertEquals(1, bc.getVertices(ng).size());
		assertEquals(1, bc.getVertices(ng1).size());
		
		assertEquals(ng, bc.getVertices(ng1).get(0).getDestino());
		
	}
	
	@Test
	public void testProcessador(){
		
		
		Processador p = new Processador(0,12);
		List<NoG> caminho = p.initProcurarCaminho();
		
		View v = new View();
		v.printWay(caminho, p.getBc().getDistancia());
		
		
	}

}
