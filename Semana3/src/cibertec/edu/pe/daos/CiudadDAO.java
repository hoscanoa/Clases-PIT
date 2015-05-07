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

	SqlSessionFactory sqlMapper = null;
	{
		String archi = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archi);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Ciudad Buscar(String id) {
		return null;
	}

	public ArrayList<Ciudad> Listado() {
		SqlSession s = sqlMapper.openSession();
		ArrayList<Ciudad> ciudades = null;
		try {
			ciudades = (ArrayList<Ciudad>) s
					.selectList("cuidadXml.SQL_ListaCiudad");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return ciudades;
	}

	public String Grabar(Ciudad obj) {
		SqlSession s = sqlMapper.openSession();
		String res = "";
		try {
			res = "Filas: " + s.insert("cuidadXml.SQL_InsertarCiudad", obj);
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
		SqlSession s = sqlMapper.openSession();
		String res = "";
		try {
			res = "Filas: " + s.update("cuidadXml.SQL_EditarCiudad", obj);
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
		SqlSession s = sqlMapper.openSession();
		String res = "";
		try {
			res = "Filas: " + s.delete("cuidadXml.SQL_EliminarCiudad", obj);
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
