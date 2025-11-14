package insa.fr.soa.demande;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("demandeur")
public class Demandeur_ressource {
	
	static private ArrayList<Demandeur> demandeurs = new ArrayList<Demandeur>();
	static private ArrayList<Demande> demandes = new ArrayList<Demande>();
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int createDemandeur(Demandeur demandeur) {
		int id = demandeurs.size();
		demandeur.setId(id);
		demandeurs.add(demandeur);
		return id;
		
	}
	@POST
	@Path("createTask")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int createDemande(Demande demande) {
		int id = demandeurs.size();
		demande.setId(id);
		demandes.add(demande);
		return id;
		
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateDemandeur(Demandeur d) {
		demandeurs.forEach(demandeur -> {
			if (demandeur.getId() == d.getId()) {
				demandeur.setAge(d.getAge());
				demandeur.setNom(d.getNom());
				demandeur.setPrenom(d.getPrenom());
			}
		});
	}
	
	@PUT
	@Path("updateTask")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateDemande(Demande d) {
		demandes.forEach(demande -> {
			if (demande.getId() == d.getId()) {
				demande.setDemande(d.getDemande());
			}
		});
	}
	
	@GET
	@Path("getDemandeur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Demandeur getDemandeur(@PathParam("id") int id, @Context UriInfo uriInfo) {
		for (Demandeur d : demandeurs) {
			if (d.getId() == id) {
				d.addLink(getUriforSelf(uriInfo, d), "self", "GET");
				d.addLink(getUriforDemande(uriInfo), "Demande", "GET");
				return d;
			}
		}
		return null;
	}
	
	private String getUriforDemande(UriInfo uriInfo) {
		String url = uriInfo.getBaseUriBuilder()
				.path(Demandeur_ressource.class)
				.build()
				.toString();
		return url;
	}
	
	private String getUriforSelf(UriInfo uriInfo, Demandeur demandeur) {
		String url = uriInfo.getBaseUriBuilder()
				.path(Demandeur_ressource.class)
				.path(Long.toString(demandeur.getId()))
				.build()
				.toString();
		return url;
	}
	
	@GET
	@Path("getDemandeurs")
	@Produces(MediaType.APPLICATION_JSON) 
	public ArrayList<Demandeur> getDemandeurs() {
		return demandeurs;
	}
	@GET
	@Path("getTasks/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public ArrayList<Demande> getDemandes(@PathParam("id") int id) {
		ArrayList<Demande> res = new ArrayList<Demande>();
		demandes.forEach(d -> {
			if (d.getDemandeur().getId() == id) {
				res.add(d);
			}
		});
		return res;
	}
	
	@DELETE
	@Path("delDemandeur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delDemandeur(@PathParam("id") int id) {
		demandeurs.removeIf( d -> {
			return d.getId() == id;
		});
	}
	
	@DELETE
	@Path("delDemande/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delDemande(@PathParam("id") int id) {
		demandes.removeIf( d -> {
			return d.getId() == id;
		});
	}

}
