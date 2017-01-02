package Agente;

public class Estado{
	
	private int	id;

	private String nome;
	private Double coordX;
	private Double coordY;
	private Double coordZ;
	
	public Estado(int id, String nome, double x, double y, double z){
		this.setId(id);
		this.setNome(nome);
		this.setCoordX(x); 
		this.setCoordY(y); 
		this.setCoordZ(z);	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getCoordX() {
		return coordX;
	}
	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}
	public Double getCoordY() {
		return coordY;
	}
	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}
	public Double getCoordZ() {
		return coordZ;
	}
	public void setCoordZ(Double coordZ) {
		this.coordZ = coordZ;
	}
	

	
	
	
}
