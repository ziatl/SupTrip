package fr.supinfo.dao;

import java.util.List;

import fr.supinfo.entites.Admin;
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.LignePanier;
import fr.supinfo.entites.User;
import fr.supinfo.entites.Voyage;

public interface ITripDAO {
	public void addUser(User u); //V
	public void addCampus(Campus c); //Admin
	public void addVoyage(Voyage v); // C
	
	public Campus getCampus(Long i); // V
	public User getUser(Long i); // C
	public Voyage getVoyage(Long i); //C
	
	public void deleteUser(Long i); // C
	public void deleteVoyage(Long i); //C
	public void deleteCampus(Long i); //A
	
	public void modUser(User u); // C
	public void modVoyage(Voyage c); // C
	public void modCampus(Campus c); //
	
	public int getNombreUsers(); //V
	public List<Campus> getlistCampus(); // V
	
	public int getNombreVoyagePossible();// V
	public List<String> getlistVoyageParVille(String source); // V
	
	public List<String> getAllTrip(); // V
	public List<Integer> getListIdBooster(); //V
	public List<String> generetedTrip();
	public List<User> getAllUser();
	public List<Voyage> getUserTrips(Long idUser);
	public Voyage getUserTrip(Long idUser);
	
	public List<LignePanier> getVoyage();
	public List<LignePanier> getVoyageVille(String ville);
	
	public Campus getCampus(String ville);
	
	public List<Admin> getAdmins();
	
	
	
}
