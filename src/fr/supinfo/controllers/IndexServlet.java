

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
import fr.supinfo.entites.Voyage;
import jdk.nashorn.internal.ir.RuntimeNode.Request;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int nbV = DaoFactory.getDao().getAllTrip().size();
	int nvE = DaoFactory.getDao().getNombreUsers();
	req.setAttribute("nbV", nbV);
	req.setAttribute("nbE", nvE);
	if (req.getSession().getAttribute("idBooster")==null) {
		List<Campus> listeCampus = DaoFactory.getDao().getlistCampus();
		req.setAttribute("listeCampus", listeCampus);
		req.setAttribute("nbC", listeCampus.size());
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}else {
		List<Campus> listeCampus = DaoFactory.getDao().getlistCampus();
		req.setAttribute("listeCampus", listeCampus);
		req.setAttribute("nbC", listeCampus.size());
		Long idUser = (Long) req.getSession().getAttribute("idUser");
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
		
		req.setAttribute("userTrips", userTrips);
		req.setAttribute("taille", trips.size());
		this.getServletContext().getRequestDispatcher("/WEB-INF/indexUser.jsp").forward(req, resp);
	}
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
