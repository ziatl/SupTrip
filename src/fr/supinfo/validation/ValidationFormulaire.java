package fr.supinfo.validation;

import java.util.List;
import java.util.Random;
import fr.supinfo.dao.DaoFactory;

public class ValidationFormulaire {
	public static boolean idBooster(Integer id) {
		int min = 100000;
		int max=999999;
		boolean rep = true;
		List<Integer> ll = DaoFactory.getDao().getListIdBooster();
		for (int p : ll){
			if(p==id ){
				rep = false;
			} else if(id>999999 || id<100000) {	
				rep = false;
			}
		}	
		return rep;
	}
}
