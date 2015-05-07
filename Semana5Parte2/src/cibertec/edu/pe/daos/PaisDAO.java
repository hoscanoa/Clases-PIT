package cibertec.edu.pe.daos;

import java.io.Reader;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cibertec.edu.pe.beans.Ciudad;
import cibertec.edu.pe.beans.Pais;

public class PaisDAO {
	
	SqlSessionFactory sqlmapper=null;
	{
		String archi="ConfiguracionIbatis.xml";
		try {
			Reader reader=Resources.getResourceAsReader(archi);
			sqlmapper=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Pais> Listar(){
		SqlSession s = sqlmapper.openSession();
		ArrayList<Pais> paises=new ArrayList<Pais>();
		try {
			paises = (ArrayList<Pais>)s.selectList("paisxml.SQL_ListaPais");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		return paises;
		
	}
}
