package cibertec.edu.pe.actions;

import java.util.ArrayList;

import cibertec.edu.pe.beans.Ciudad;
import cibertec.edu.pe.beans.Pais;
import cibertec.edu.pe.daos.CiudadDAO;
import cibertec.edu.pe.daos.PaisDAO;

import com.opensymphony.xwork2.ActionSupport;

public class CiudadAction extends ActionSupport {
	private int estado;
	private Ciudad ciudadbean;
	private ArrayList<Ciudad> ciudades;
	private ArrayList<Pais> paises;
	 
	public String Buscar(){
		estado=1;
		PaisDAO pdao=new PaisDAO();
		paises = pdao.Listar();
		CiudadDAO dao=new CiudadDAO();
		ciudadbean = dao.Buscar(ciudadbean.getIdCiu());
		return SUCCESS;
	}
	
	public String Nuevo(){
		estado=0;
		PaisDAO pdao=new PaisDAO();
		paises = pdao.Listar();
		return SUCCESS;
	}	
	public String Eliminar(){
		CiudadDAO dao=new CiudadDAO();
		dao.Eliminar(ciudadbean);
		return SUCCESS;
	}
	public String Listado(){
		CiudadDAO dao=new CiudadDAO();
		ciudades=dao.Listado();
		return SUCCESS;
	}	
	public String Grabar(){		
		CiudadDAO dao=new CiudadDAO();
		if(estado==0)
			dao.Grabar(ciudadbean);
		else
			dao.Editar(ciudadbean);
		
		return SUCCESS;
	}

	
	public void setCiudadbean(Ciudad ciudadbean) {
		this.ciudadbean = ciudadbean;
	}

	public Ciudad getCiudadbean() {
		return ciudadbean;
	}


	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}


	public ArrayList<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEstado() {
		return estado;
	}

	public void setPaises(ArrayList<Pais> paises) {
		this.paises = paises;
	}

	public ArrayList<Pais> getPaises() {
		return paises;
	}

}
