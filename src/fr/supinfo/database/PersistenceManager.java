package fr.supinfo.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;
	public static EntityManagerFactory getEntityManagerFactory(){
		  if(emf == null){
			  	emf = Persistence.createEntityManagerFactory("Sup-Trip");
		  }
		 return emf;
	 }
	  
	 public static EntityManager getEntityManager(){
		  return getEntityManagerFactory().createEntityManager();
	 }
	  
	 public static void closeEntityManagerFactory() {
			 if(emf != null && emf.isOpen()){
				 emf.close();
			 }
	 }	
	  
}
