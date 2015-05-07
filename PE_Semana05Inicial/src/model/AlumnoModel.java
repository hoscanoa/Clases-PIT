package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Alumno;

public class AlumnoModel {
	
	private EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("UnitSimulacro");
	
	public void registrar(Alumno a){
		
		EntityManager manager = null;
		try {
			manager = fabrica.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(a);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
		
		
		
	}
	

}
