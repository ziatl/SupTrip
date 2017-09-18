package fr.supinfo.webservice;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import org.json.simple.JSONValue;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.LignePanier;

@Path("/full")
public class TripRest {
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTrip() throws IOException{
		LinkedList<String> list = new LinkedList<String>();
		for (String v : DaoFactory.getDao().getAllTrip()){
			list.add(v);
		}
		 StringWriter out = new StringWriter();
		 JSONValue.writeJSONString(list, out);
		 String jsonText = out.toString();
		  System.out.print(jsonText);
		return jsonText;
	}
	
	@GET
	@Path("{ville}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTripVille(@PathParam("ville") String ville) throws IOException{
		LinkedList<String> list = new LinkedList<String>();
		for (LignePanier v : DaoFactory.getDao().getVoyageVille(ville)){
			list.add(v.getNom());
		}
		 StringWriter out = new StringWriter();
		 JSONValue.writeJSONString(list, out);
		 String jsonText = out.toString();
		  System.out.print(jsonText+"jkd"+ville);
		return jsonText;
	}
	@GET
	@Path("/toto/{ville}/{pays}")
	@Produces(MediaType.TEXT_HTML)
	public String getBonjour(@PathParam("ville") String ville,@PathParam("pays") String pays) throws IOException{
		String st = ville+pays;
		return st;
	}

}
