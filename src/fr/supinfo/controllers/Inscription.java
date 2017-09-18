package fr.supinfo.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.User;
import fr.supinfo.validation.ValidationFormulaire;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {

	public static String BOUTON;
	public static int ID_BOOSTER;
	public static String NOM;
	public static String PRENOM;
	public static String EMAIL;
	public static String PASSWORD;
	public static String PASSWORD_CONF;
	public static Long ID_CAMPUS;
	public static Long ID_SESSION;
	Map<String, String> erreurs = new HashMap<String, String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Campus> lc = DaoFactory.getDao().getlistCampus();
		request.setAttribute("listeCampus", lc);
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BOUTON = request.getParameter("bouton");
		NOM = request.getParameter("nom");
		PRENOM = request.getParameter("prenom");
		EMAIL = request.getParameter("email");
		PASSWORD = request.getParameter("password");
		PASSWORD_CONF = request.getParameter("passwordConf");
		ID_CAMPUS = Long.parseLong(request.getParameter("idCampus"));
		try {
			ID_BOOSTER = Integer.parseInt(request.getParameter("idBooster"));
		} catch (Exception e) {
			erreurs.put("id", "veuillez saisir un Id valide !!!");
		}
		
		User user = null;
		if (BOUTON.equals("inscription")) {
			if (NOM.length() < 1) {
				erreurs.put("nom", "Veuillez saisir un nom valide SVP");
			}
			if (PRENOM.length() < 1) {
				erreurs.put("prenom", "Veuillez saisir un prenom valide SVP");
			}

			if (EMAIL != null) {
				if (!EMAIL.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
					erreurs.put("email", "Merci de saisir une adresse mail valide.");
				}
			}
			Boolean b = ValidationFormulaire.idBooster(ID_BOOSTER);
			if (b == false) {
				erreurs.put("id", "Ce id ne vous appartient pas !!");
			}

			if (PASSWORD != null && PASSWORD_CONF != null) {
				if (!PASSWORD.equals(PASSWORD_CONF)) {
					erreurs.put("password", "Les mots de passe entrés sont différents !!");
				} else if (PASSWORD.length() < 6) {
					erreurs.put("password", "au moins 6 caractères !!");
				}
			} else {
				erreurs.put("password", "Merci de saisir et confirmer votre mot de passe.");
			}
			Campus campus = DaoFactory.getDao().getCampus(ID_CAMPUS);
			user = new User(NOM, ID_BOOSTER, PRENOM, EMAIL, PASSWORD, campus);
			request.setAttribute("user", user);
			if (erreurs.isEmpty()) {
				System.out.println("inserer");
				DaoFactory.getDao().addUser(user);
				
				response.sendRedirect("connexion?connexion");
			} else {
				System.out.println("ereeeeeeeeeeeer");
					System.out.println(erreurs.values());
					request.setAttribute("erreurs", erreurs);
					doGet(request, response);
			}
			
		} 
		
		request.setAttribute("erreurs", erreurs);
		erreurs.clear();
	}
}
