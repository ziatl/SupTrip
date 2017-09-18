package fr.supinfo.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.LignePanier;
import fr.supinfo.entites.Voyage;

/**
 * Servlet implementation class addTripBouton
 */
@WebServlet("/user/addBouton")
public class addTripBouton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/indexUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bouton = request.getParameter("bouton");
		String[] pats = bouton.split(" - ");
		String source = pats[0];
		String destiantion = pats[1];
		Campus cSource = DaoFactory.getDao().getCampus(source);
		Campus cDesitnation = DaoFactory.getDao().getCampus(destiantion);
		Long i = (Long) request.getSession().getAttribute("idUser");
		Voyage v = new Voyage(source+"-"+destiantion, cSource.getVille(), cDesitnation.getVille(), DaoFactory.getDao().getUser(i ), cSource, cDesitnation);
		
		DaoFactory.getDao().addVoyage(v);
		
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/indexUser.jsp").forward(request, response);
	}

}
