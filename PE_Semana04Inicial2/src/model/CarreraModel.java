package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Carrera;

public class CarreraModel {

	
	private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("UnitSimulacro");
	
	public void registrar(Carrera c){
		
		
		EntityManager manager = null;
		
		try {
		manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(c);
		manager.flush();
		manager.getTransaction().commit();
		
		} catch (Exception e) {
		manager.getTransaction().rollback();
		e.printStackTrace();
		}finally{
			manager.close();
		}
		
	}
}
