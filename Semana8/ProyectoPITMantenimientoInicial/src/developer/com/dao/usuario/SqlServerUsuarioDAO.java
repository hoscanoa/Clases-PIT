package developer.com.dao.usuario;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import developer.com.bean.Usuario;

public class SqlServerUsuarioDAO implements UsuarioDAO {
	
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

	

	public Usuario Loguear(Usuario obj) {
		SqlSession s = sqlmapper.openSession();
		Usuario Usuario = null;
		try {
			Usuario = (Usuario) s.selectOne("usuarioxml.SQL_LOGUEAR_USUARIO", obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return Usuario;
	}

	
	
}
