package cibertec.edu.pe.daos;

import java.io.Reader;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cibertec.edu.pe.beans.Ciudad;

public class CiudadDAO {
	SqlSessionFactory sqlmapper = null;
	{
		String archi = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archi);
			sqlmapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Ciudad Buscar(String id) {
		SqlSession s = sqlmapper.openSession();
		Ciudad ciudad = null;
		try {
			ciudad = (Ciudad) s.selectOne("ciudadxml.SQL_BuscarCiudad", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return ciudad;
	}

	public ArrayList<Ciudad> Listado() {
		SqlSession s = sqlmapper.openSession();
		ArrayList<Ciudad> ciudades = null;
		try {
			ciudades = (ArrayList<Ciudad>) s
					.selectList("ciudadxml.SQL_ListaCiudad");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return ciudades;
	}

	public String Grabar(Ciudad obj) {
		SqlSession s = sqlmapper.openSession();
		String res = "";
		try {
			res = "Filas : " + s.insert("ciudadxml.SQL_InsertarCiudad", obj);
			s.commit();
		} catch (Exception e) {
			res = e.getMessage();
			s.rollback();
		} finally {
			s.close();
		}
		return res;
	}

	public String Editar(Ciudad obj) {
		SqlSession s = sqlmapper.openSession();
		String res = "";
		try {
			res = "Filas : " + s.update("ciudadxml.SQL_EditarCiudad", obj);
			s.commit();
		} catch (Exception e) {
			res = e.getMessage();
			s.rollback();
		} finally {
			s.close();
		}
		return res;
	}

	public String Eliminar(Ciudad obj) {
		SqlSession s = sqlmapper.openSession();
		String res = "";
		try {
			res = "Filas : " + s.delete("ciudadxml.SQL_EliminarCiudad", obj);
			s.commit();
		} catch (Exception e) {
			res = e.getMessage();
			s.rollback();
		} finally {
			s.close();
		}
		return res;
	}

}
