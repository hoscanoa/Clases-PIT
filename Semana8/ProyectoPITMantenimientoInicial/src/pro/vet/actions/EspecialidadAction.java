package pro.vet.actions;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import pro.vet.beans.especialidad;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "ProyectoPIT")
public class EspecialidadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList<especialidad> especialidades;

	SqlSessionFactory sqlmapper = null;
	{
		try {
			Reader archi = Resources
					.getResourceAsReader("ConfiguracionIbatis.xml");
			sqlmapper = new SqlSessionFactoryBuilder().build(archi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Action(value = "AListadoEspecialidad", results = { @Result(name = "success", type = "json") })
	public String ListadoEspecialidad() {
		SqlSession sesion = sqlmapper.openSession();
		try {
			especialidades = (ArrayList<especialidad>) sesion
					.selectList("especialidadXML.listado");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
		return SUCCESS;
	}

	public void setEspecialidades(ArrayList<especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public ArrayList<especialidad> getEspecialidades() {
		return especialidades;
	}
}
