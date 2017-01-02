package Agente;

import java.util.HashMap;

public class BancoDados {
	int noIndex;
	HashMap<Integer, NoG> mapa;
	
	public BancoDados(){

		this.mapa = new HashMap<>();
		this.initEstados();		
		this.initConexoes();

	}
	
	private void initEstados(){
		try{

			Estado e = new Estado(0, "Andromeda", 0, 0, 0);
			addEstado(e);

			e = new Estado(1, "Galáxia de Bode", 1300, 1500, 0);
			addEstado(e);

			e = new Estado(2, "Galáxia de Cartwheel", -500, 700, 1550);
			addEstado(e);

			e = new Estado(3, "Grande Nuvem de Magalhães", 1700, 500, 2000);
			addEstado(e);

			e = new Estado(4, "Galáxia Olho Negro", 0, 3000, 0);
			addEstado(e);

			e = new Estado(5, "Galáxia Charuto", -1150, 2000, 2500);
			addEstado(e);

			e = new Estado(6, "Objeto de Hoag", 90, 2500, 4400);
			addEstado(e);

			e = new Estado(7, "Cosmos Redshift 7", -1100, 975, 4500);
			addEstado(e);

			e = new Estado(8, "Gláxia do Cometa", 1340, 2000, 2000);
			addEstado(e);

			e = new Estado(9, "Pequena Núvem de Magalhães", 1345, 750, 4000);
			addEstado(e);

			e = new Estado(10, "Galáxia do Girino", 2540, 1500, 5800);
			addEstado(e);

			e = new Estado(11, "Galáxia do Cata-Vento", 2800, 1500, 4000);
			addEstado(e);

			e = new Estado(12, "Galáxia do Sombreiro", 0, 0, 6000);
			addEstado(e);
			

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void initConexoes(){
		Conexao caux;
		int i= 0;
		try {
			
			//Conexões de Andromeda 0
			i=0;
			caux = new Conexao(mapa.get(i), mapa.get(1));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(2));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(4));
			mapa.get(i).addConexao(caux);
			
			
			//Conexões da Galáxia de Bode 1
			i=1;
			caux = new Conexao(mapa.get(i), mapa.get(4));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(3));
			mapa.get(i).addConexao(caux);
			
			
			//Conexões da Galáxia Olho Negro 4
			i=4;
			caux = new Conexao(mapa.get(i), mapa.get(2));
			mapa.get(i).addConexao(caux);
			
			//Conexões da Galáxia de Cartwheel 2 
			i=2;
			caux = new Conexao(mapa.get(i), mapa.get(3));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(5));
			mapa.get(i).addConexao(caux);
			
			//Conexões da Grande Núvem de Magalhães 3
			i=3;
			caux = new Conexao(mapa.get(i), mapa.get(8));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(9));
			mapa.get(i).addConexao(caux);
			
			//Conexões Charuto
			i=5;
			caux = new Conexao(mapa.get(i), mapa.get(7));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(8));
			mapa.get(i).addConexao(caux);
		
			//Conexões do Cometa
			i=8;
			caux = new Conexao(mapa.get(i), mapa.get(6));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(9));
			mapa.get(i).addConexao(caux);
			
			//Conexões Pequena Núvem de Magalhães 9
			i=9;
			caux = new Conexao(mapa.get(i), mapa.get(6));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(11));
			mapa.get(i).addConexao(caux);
			
			//Conexões Cosmos Redshift 7 7
			i=7;
			caux = new Conexao(mapa.get(i), mapa.get(6));
			mapa.get(i).addConexao(caux);
			
			//Conexões Galáxia do Girino 10
			i=10;
			caux = new Conexao(mapa.get(i), mapa.get(11));
			mapa.get(i).addConexao(caux);
			caux = new Conexao(mapa.get(i), mapa.get(12));
			mapa.get(i).addConexao(caux);
			
			
			//Conexões Galáxia do Sombrero 12
			i=12;
			caux = new Conexao(mapa.get(i), mapa.get(6));
			mapa.get(i).addConexao(caux);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void addEstado(Estado e) throws Exception{
		NoG newNode = new NoG(e.getId(), e);
		
		if(mapa.containsKey(e.getId())){
			throw new Exception("Nodo com estado "+ e.getNome() +" e id "+e.getId()+" já existe");
		}
		
		mapa.put(e.getId(), newNode);

	}
		
	
	public void addNo(NoG e){
		
		if(!mapa.containsKey(e.getId())){
			mapa.put(e.getId(), e);
		}else{
			throw new RuntimeException("No " + e.getId() + " já existe!");
		}
	}
	
	public NoG getNo(Integer id){
		
		if(!mapa.containsKey(id))
			throw new RuntimeException("No " + id + " não existe!");
		else
			mapa.get(id);
		
		
		return mapa.get(id);
	}
	
	public int getNextIndex(){
		noIndex++;
		return this.noIndex;}
	
	
}
