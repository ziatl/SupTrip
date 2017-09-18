package fr.supinfo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.User;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/user/profil")
public class Profil extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = DaoFactory.getDao().getUser((Long) request.getSession().getAttribute("idUser"));
		request.setAttribute("user", u);
		this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
