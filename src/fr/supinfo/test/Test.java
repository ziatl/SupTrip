package fr.supinfo.test;

import java.util.List;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entites.Campus;
import fr.supinfo.entites.Voyage;

public class Test {

	public static void main(String[] args) {
	/*	Campus cc = new Campus("Lome", 3455, "zizoa@gmail.com", "grande ecole mondiale");
		
		cc.setNom("Supinfo"+cc.getVille());
		DaoFactory.getDao().addCampus(cc);*/
		
		List<Voyage> liste = DaoFactory.getDao().getUserTrips(1L);
		for (Voyage l : liste) {
			System.out.println(l.getNom());
		}
		int nb = DaoFactory.getDao().getNombreVoyagePossible();
		System.out.println(nb);
		List<String> liste1 = DaoFactory.getDao().getlistVoyageParVille("Metz");
		try {
			for (String l : liste1) {
				System.out.println(l);
			}
		} catch (Exception e) {
			
		}
	}

}
