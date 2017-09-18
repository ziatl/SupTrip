package fr.supinfo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.User;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	public static String ID_BOOSTER = "idBooster";
	public static String PASSWORD = "password";
	public static String BOUTON = "bouton";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> liste = DaoFactory.getDao().getAllUser();
		String bouton = request.getParameter("bouton");
		
		
		if (bouton.equals("connexion")){
			String password = request.getParameter(PASSWORD);
			int idBooster = 0;
			try {
				idBooster = Integer.parseInt(request.getParameter(ID_BOOSTER));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			Boolean bool = false;
			for (User u : liste){
				
				if( u.getPassword().equals(password) && idBooster == u.getIdBooster() ) {
					request.getSession().setAttribute("idUser", u.getIdUser());
					request.getSession().setAttribute("password", password);
					request.getSession().setAttribute("idBooster", idBooster);				
					System.out.println("connecte!!");
					bool = true;
				}}
				if (bool == true) {
					
					response.sendRedirect(request.getContextPath()+"/user/trip");
				}else{
					String mess = "Informations erronees!!!";
					request.setAttribute("mess", mess);
					response.sendRedirect(request.getContextPath()+"/connexion");
				}		
		}
		if (bouton.equals("disconnect")){
			request.getSession().removeAttribute("password");
			request.getSession().removeAttribute("idBooster");	
			doGet(request, response);
		}	
	}


}
