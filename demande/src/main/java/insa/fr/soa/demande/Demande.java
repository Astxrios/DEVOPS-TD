package insa.fr.soa.demande;

public class Demande {
	private Demandeur demandeur;
	private String demande;
	private int id;
	
	public Demandeur getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}
	public Demande() {
		super();
	}
	public String getDemande() {
		return demande;
	}
	public void setDemande(String demande) {
		this.demande = demande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Demande(Demandeur demandeur, String demande, int id) {
		super();
		this.demandeur = demandeur;
		this.demande = demande;
		this.id = id;
	}
}
