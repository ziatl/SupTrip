package fr.supinfo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.User;
import fr.supinfo.entites.Voyage;

import fr.supinfo.validation.ValidationFormulaire;

/**
 * Servlet implementation class Trips
 */
@WebServlet("/user/trip")
public class Trips extends HttpServlet {
	
	public static String ID_SOURCE = "idSource";
	public static String ID_DEST = "idDest";
	public static String BOUTON = "bouton";
	Long idUser = null;   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idUser = (Long) request.getSession().getAttribute("idUser");
		
		List<Voyage> userTrips = DaoFactory.getDao().getUserTrips(idUser);
		
		
		List<Voyage> trips = new ArrayList<Voyage>();
		try {
			for (Voyage v : userTrips) {
				if (v.isStatut()==false) {
					trips.add(v);
				}	
			}
		} catch (Exception e) {
			
		}
		request.setAttribute("userTrips", trips);
		request.setAttribute("taille", trips.size());
		List<Campus> lc = DaoFactory.getDao().getlistCampus();
		
		request.setAttribute("listeCampus", lc);
		this.getServletContext().getRequestDispatcher("/WEB-INF/connect.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long source = Long.parseLong(request.getParameter(ID_SOURCE));
		Long destination = Long.parseLong(request.getParameter(ID_DEST));
		String bouton = request.getParameter(BOUTON);
		Boolean existe = true;
		idUser = (Long) request.getSession().getAttribute("idUser");
		Voyage selection = new Voyage();		
	
		if (bouton.equals("addTrip")){	
			if(source==destination){
				existe = false;			
			}else{	
					selection.setCampusSource(DaoFactory.getDao().getCampus(source));
					selection.setCampusDestination(DaoFactory.getDao().getCampus(destination));
					selection.setNom(DaoFactory.getDao().getCampus(source).getVille()+" - "+DaoFactory.getDao().getCampus(destination).getVille());
					selection.setSource(DaoFactory.getDao().getCampus(source).getVille());
					selection.setDestination(DaoFactory.getDao().getCampus(destination).getVille());
					selection.setStatut(false);
					selection.setUser(DaoFactory.getDao().getUser(idUser));}
			}	
		if(existe==true){
			DaoFactory.getDao().addVoyage(selection);
		}else {
			request.setAttribute("erreur", "La source ne peut pas etre egale a la destination !!!");
		}	
		doGet(request, response);
	}

}
