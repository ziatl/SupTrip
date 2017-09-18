package fr.supinfo.entites;

public class LignePanier {
	private int num;
	
	private String nom;
	private String source;
	private String destination;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public LignePanier(int num,String nom, String source, String destination) {
		super();
		this.num = num;
		this.nom = nom;
		this.source = source;
		this.destination = destination;
	}
	
	public LignePanier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
