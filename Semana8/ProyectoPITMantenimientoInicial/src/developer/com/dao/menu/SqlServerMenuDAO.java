package developer.com.dao.menu;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import developer.com.bean.Menu;

public class SqlServerMenuDAO implements MenuDAO {

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
	
	public List<Menu> listar(int idrol) {
		SqlSession s = sqlmapper.openSession();
		ArrayList<Menu> menus = null;
		try {
			menus = (ArrayList<Menu>) s
					.selectList("menuxml.SQL_LISTAR_MENU_ROL",idrol);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return menus;
	}

	@Override
	public List<Menu> listarhijos(int idpadre) {
		// TODO Auto-generated method stub
		SqlSession s = sqlmapper.openSession();
		ArrayList<Menu> menus = null;
		try {
			menus = (ArrayList<Menu>) s
					.selectList("menuxml.SQL_LISTAR_MENU_HIJO",idpadre);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return menus;
	}

	
}
