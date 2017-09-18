package fr.supinfo.dao;

public class DaoFactory {	
	public static TripDAOImpl getDao(){
		return new TripDAOImpl();
	}
}