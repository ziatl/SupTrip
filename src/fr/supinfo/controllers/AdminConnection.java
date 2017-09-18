package fr.supinfo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;

/**
 * Servlet implementation class AdminConnection
 */
@WebServlet("/login")
public class AdminConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("bouton").equals("campus")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			List<fr.supinfo.entites.Admin> listA = DaoFactory.getDao().getAdmins();
			for (fr.supinfo.entites.Admin a : listA) {
				if (login.equals(a.getLogin()) && password.equals(a.getPassword())) {
					request.getSession().setAttribute("loginAdmin",login );
					response.sendRedirect("admin");
				}
				else{
					response.sendRedirect("index");
				}
		}
		}else if (request.getParameter("bouton").equals("deconnexion")){
			request.getSession().removeAttribute("loginAdmin");
			response.sendRedirect("index");
			
		}
		
		}

}
