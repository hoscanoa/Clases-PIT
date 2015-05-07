package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Empleado;


public class ModelEmpleado {

	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("PE");
	/*
	 * JPQL es un select a nivel de clases
	 * las clases son en mayusculas
	 */
		
	public List<Empleado>empleadoXcargo(String cargo){
		
		EntityManager manager = null;
		List<Empleado>data = null;
		
		try {
			manager = fabrica.createEntityManager();
			String sql = "Select e from Empleado e where e.cargo.descripcion = :param";
			TypedQuery<Empleado> q = manager.createQuery(sql,Empleado.class);
			q.setParameter("param", cargo);
			
			data= q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
}
	public int CantidadEmpleadoXCargo(String cargo, int edad){
		EntityManager manager = null;
		int cantidad = -1;
		
		try {
			manager = fabrica.createEntityManager();
			String sql = "Select count(e) from Empleado e where e.cargo.descripcion = ?1 and e.edad =?2";
			TypedQuery<Long> q = manager.createQuery(sql,Long.class);
			q.setParameter(1, cargo);
			q.setParameter(2, edad);
			
			cantidad =(int)(long) q.getSingleResult();//SingleResult solo objeto
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cantidad;
	}
	public Empleado empleadoEdadMaxima(){
		EntityManager manager = null;
		Empleado objs = null;
			try {
				manager = fabrica.createEntityManager();
				String sql = "Select e from Empleado e where e.edad = (select max(x.edad) from Empleado x)";
				TypedQuery<Empleado> q = manager.createQuery(sql,Empleado.class);
				objs = q.getSingleResult();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return objs;
	}
	public int ActualizaEdad(String descripcion , int edad){
		EntityManager manager = null;
		int cantidad = -1;
		try {
			manager = fabrica.createEntityManager();
			manager.getTransaction().begin();
			String sql = "Update Empleado e set e.edad = ?1 where e.cargo.descripcion = ?2";
			
			Query q =manager.createQuery(sql);
			q.setParameter(1, edad);
			q.setParameter(2, descripcion);
			cantidad = q.executeUpdate();
			manager.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}
		return cantidad;
	}
}
