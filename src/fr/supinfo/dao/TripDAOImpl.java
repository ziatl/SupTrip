package fr.supinfo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.supinfo.database.PersistenceManager;
import fr.supinfo.entites.Admin;
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.LignePanier;
import fr.supinfo.entites.User;
import fr.supinfo.entites.Voyage;

public class TripDAOImpl implements ITripDAO{

	@Override
	public void addUser(User u) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		em.close();
		
	}

	@Override
	public void addCampus(Campus c) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		em.close();	
		
	}

	@Override
	public void addVoyage(Voyage v) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(v);
		et.commit();
		em.close();
		
	}

	@Override
	public Campus getCampus(Long i) {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.find(Campus.class, i);
	}

	@Override
	public User getUser(Long i) {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.find(User.class, i);
	}

	@Override
	public Voyage getVoyage(Long i) {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.find(Voyage.class, i);
	}

	@Override
	public void deleteUser(Long i) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		User u = em.find(User.class, i);
		et.begin();
		em.remove(u);
	
		et.commit();
		em.close();
		
	}

	@Override
	public void deleteVoyage(Long i) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Voyage v = em.find(Voyage.class, i);
		et.begin();
		em.remove(v);
		et.commit();
		em.close();
	}

	@Override
	public void deleteCampus(Long i) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Campus c = em.find(Campus.class, i);
		et.begin();
		em.remove(c);
		et.commit();
		em.close();
	}

	@Override
	public void modUser(User u) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(u);
		et.commit();
		em.close();
	}

	@Override
	public void modVoyage(Voyage c) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
		em.close();
	}

	@Override
	public void modCampus(Campus c) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
		em.close();		
	}

	@Override
	public int getNombreUsers() {
		EntityManager em = PersistenceManager.getEntityManager();
		return  (int) DaoFactory.getDao().getAllUser().size();
	}

	@Override
	public List<Campus> getlistCampus() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query q = em.createQuery("select c from Campus c");
		return q.getResultList();
	}


	@Override
	public int getNombreVoyagePossible() {
		
		return DaoFactory.getDao().getAllTrip().size();
	}

	

	@Override
	public List<String> getAllTrip() {
		List<Campus> l = DaoFactory.getDao().getlistCampus();
		
		List<String> liste = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			for (int j = i+1; j < l.size(); j++) {		
				liste.add(l.get(i).getVille()+" - "+l.get(j).getVille());	
				liste.add(l.get(j).getVille()+" - "+l.get(i).getVille());			
			}	
		}
		return liste;
	}

	@Override
	public List<Integer> getListIdBooster() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query req = em.createQuery("select u.idBooster from User u ");
		return req.getResultList();
	}
	@Override
	public List<String> generetedTrip() {
		List<Campus> l = DaoFactory.getDao().getlistCampus();
		
		List<String> liste = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			for (int j = i+1; j < l.size(); j++) {		
				liste.add(l.get(i).getVille()+" - "+l.get(j).getVille());	
				liste.add(l.get(j).getVille()+" - "+l.get(i).getVille());			
			}	
		}
		return liste;	
	}
	@Override
	public List<User> getAllUser() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query req = em.createQuery("select u from User u");
		return req.getResultList();
	}

	@Override
	public List<Voyage> getUserTrips(Long idUser) {
		EntityManager em = PersistenceManager.getEntityManager();
		Query req = em.createQuery("select v from Voyage v where v.user.idUser=:x");
					
		req.setParameter("x", idUser);
		return req.getResultList();
	}

	@Override
	public Voyage getUserTrip(Long idUser) {
		EntityManager em = PersistenceManager.getEntityManager();
		Query req = em.createQuery("select v from Voyage v where v.user.idUser=:x");				
		req.setParameter("x", idUser);
		return (Voyage) req.getSingleResult();
	}

	public Voyage getTrip(Long valider) {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.find(Voyage.class, valider);
	}
	@Override
	public List<String> getlistVoyageParVille(String ville) {
		EntityManager em = PersistenceManager.getEntityManager();
		List<String> retour = new ArrayList<String>();
		List<String> voyage = DaoFactory.getDao().generetedTrip();
		String [] pats;
		for (String v : voyage) {
			pats = v.split(" - ");
			if (pats[0].equals(ville) || pats[1].equals(ville)){
				retour.add(v);
			}			
		}
		return retour;
	}

	@Override
	public List<LignePanier> getVoyage() {
		List<String> voyage = DaoFactory.getDao().getAllTrip();
		List<LignePanier> retour = new ArrayList<LignePanier>();
		
		String pats[];
		int num = 1;
		for (String v : voyage) {
			pats = v.split(" - ");
			LignePanier l = new LignePanier(num,v, pats[0], pats[1]);
			retour.add(l);
			num++;
		}
		return retour;
	}

	@Override
	public List<LignePanier> getVoyageVille(String ville) {
		EntityManager em = PersistenceManager.getEntityManager();
		List<String> voyage = DaoFactory.getDao().getAllTrip();
		List<LignePanier> retour = new ArrayList<LignePanier>();
		
		String pats[];
		int num = 1;
		for (String v : voyage) {
			pats = v.split(" - ");
			
			if (pats[0].equals(ville) || pats[1].equals(ville)){
				LignePanier l = new LignePanier(num,v, pats[0], pats[1]);
				retour.add(l);
				num++;
			}
		}
		return retour;	
	}

	@Override
	public Campus getCampus(String ville) {
		EntityManager em = PersistenceManager.getEntityManager();
		Query req = em.createQuery("select c from Campus c where c.ville like :x");				
		req.setParameter("x","%" +ville+"%");
	
		return (Campus) req.getSingleResult();
	}

	@Override
	public List<Admin> getAdmins() {
		EntityManager em = PersistenceManager.getEntityManager();
		Query req = em.createQuery("select a from Admin a");	
		return req.getResultList();
	}
	
}
