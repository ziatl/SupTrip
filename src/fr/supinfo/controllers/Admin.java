package fr.supinfo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.Campus;



/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/addCampus.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String ville = request.getParameter("ville");
				int contact = Integer.parseInt(request.getParameter("contact"));
				String email = request.getParameter("email");
				String description = request.getParameter("description");
				Campus c = new Campus(ville,contact, email, description);
				c.setNom("Supinfo "+c.getVille());
				DaoFactory.getDao().addCampus(c);
				
		} catch (RuntimeException e) {
			System.out.println("erreur venant de "+e.getMessage());
		
		}
			
		doGet(request, response);
	}

}
