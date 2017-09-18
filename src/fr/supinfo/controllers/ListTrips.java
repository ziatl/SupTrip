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
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.LignePanier;


@WebServlet("/list")
public class ListTrips extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<Campus> listeCampus = DaoFactory.getDao().getlistCampus();
		request.setAttribute("listeCampus", listeCampus);
		
	List<LignePanier> mp = DaoFactory.getDao().getVoyage();
		request.setAttribute("mp", mp);
		request.getServletContext().getRequestDispatcher("/WEB-INF/listTrips.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ville = request.getParameter("ville");
		if (ville.isEmpty()){
			List<LignePanier> liste = DaoFactory.getDao().getVoyage();
			request.setAttribute("mp", liste);
		}else{
			List<LignePanier> liste = DaoFactory.getDao().getVoyageVille(ville);
			request.setAttribute("mp", liste);
		}
		
		if (request.getSession().getAttribute("idBooster")==null) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/listTrips.jsp").forward(request, response);
		}else {
			request.getServletContext().getRequestDispatcher("/WEB-INF/listTripsUser.jsp").forward(request, response);
		}
		
	}

}
