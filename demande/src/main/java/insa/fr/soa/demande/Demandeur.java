package insa.fr.soa.demande;

import java.util.ArrayList;

public class Demandeur {
	private int id;
	private String nom;
	private ArrayList<Link> links = new ArrayList<Link>();
	public Demandeur() {
		super();
	}
	
	
	private String prenom;
	private int age;
	
	public void addLink(String uri, String rel, String methode) {
		Link newLink = new Link();
		newLink.setUri(uri);
		newLink.setRel(rel);
		newLink.setMethode(methode);
		links.add(newLink);
	}
	
	public ArrayList<Link> getLinks() {
		return links;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public Demandeur(int id, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
