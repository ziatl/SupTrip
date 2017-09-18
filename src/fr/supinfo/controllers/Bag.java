package fr.supinfo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.LignePanier;
import fr.supinfo.entites.Voyage;

/**
 * Servlet implementation class Bag
 */
@WebServlet("/user/bag")
public class Bag extends HttpServlet {
	public static String BOUTON = "bouton";
	
       

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
		Long supprimer = 0L;
		Long valider =0L;
		try {
				supprimer = Long.parseLong(request.getParameter("supprimer"));
				System.out.println("supprimer = "+supprimer);
				DaoFactory.getDao().deleteVoyage(supprimer);
				request.getRequestDispatcher("/WEB-INF/bag.jsp").forward(request, response);
				this.getServletContext().getRequestDispatcher("/WEB-INF/bag.jsp").forward(request, response); 
		} catch (Exception e) {
			
		}
		try {	
		    	valider = Long.parseLong(request.getParameter("valider"));
		    	System.out.println("valider = "+valider);    	
				Voyage v = DaoFactory.getDao().getTrip(valider);
				v.setStatut(true);
				DaoFactory.getDao().modVoyage(v);	
				this.getServletContext().getRequestDispatcher("/WEB-INF/bag.jsp").forward(request, response); 
				
		} catch (Exception e) {
			
		}	
		this.getServletContext().getRequestDispatcher("/WEB-INF/bag.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idUser = (long) request.getSession().getAttribute("idUser");
		for (Voyage l : DaoFactory.getDao().getUserTrips(idUser)){
			l.setStatut(true);
			DaoFactory.getDao().modVoyage(l);
		}
		
		doGet(request, response);
	}
}
