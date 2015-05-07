package pro.vet.actions;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import pro.vet.beans.doctor;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "ProyectoPIT")
public class DoctorAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList<doctor> doctores;
	private doctor doctorbean;
	private String id;

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

	@Action(value = "AListadoDoctor", results = { @Result(name = "success", type = "json") })
	public String ListadoDoctor() {
		SqlSession sesion = sqlmapper.openSession();
		try {
			doctores = (ArrayList<doctor>) sesion
					.selectList("doctorXML.ListadoDoctor");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
		return SUCCESS;
	}

	@Action(value = "AGrabaDoctor", results = { @Result(name = "success", type = "dispatcher") })
	public String GrabaDoctor() {

		SqlSession sesion = sqlmapper.openSession();
		try {
			String res;

			if (id.equals("")) {
				res = "act"
						+ sesion.insert("doctorXML.GrabaDoctor", doctorbean);
			} else {
				res = "act"
						+ sesion.update("doctorXML.EditaDoctor", doctorbean);
			}

			sesion.commit();
			System.out.println(res);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}

		return SUCCESS;
	}

	@Action(value = "AEliminaDoctor", results = { @Result(name = "success", type = "json") })
	public String EliminaDoctor() {
		SqlSession sesion = sqlmapper.openSession();
		try {
			String res = "act " + sesion.delete("doctorXML.EliminaDoctor", id);
			System.out.println(res);
			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
		return SUCCESS;
	}

	@Action(value = "ABuscaDoctor", results = { @Result(name = "success", type = "json") })
	public String BuscaDoctor() {
		SqlSession sesion = sqlmapper.openSession();
		try {
			doctorbean = (doctor) sesion.selectOne("doctorXML.BuscaDoctor", id);
			System.out.println("nom "
					+ doctorbean.getEspecialidadbean().getIdespecialidad());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
		return SUCCESS;
	}

	public void setDoctores(ArrayList<doctor> doctores) {
		this.doctores = doctores;
	}

	public ArrayList<doctor> getDoctores() {
		return doctores;
	}

	public void setDoctorbean(doctor doctorbean) {
		this.doctorbean = doctorbean;
	}

	public doctor getDoctorbean() {
		return doctorbean;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
