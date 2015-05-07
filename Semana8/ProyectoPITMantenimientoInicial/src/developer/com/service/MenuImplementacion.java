package developer.com.service;

import java.util.List;

import developer.com.bean.Menu;
import developer.com.dao.Factory;
import developer.com.dao.SQLServerFactory;
import developer.com.dao.menu.MenuDAO;
import developer.com.dao.usuario.UsuarioDAO;

public class MenuImplementacion implements MenuDAO{
	
	Factory factory=SQLServerFactory.getFactory(1);
	MenuDAO dao=factory.getMenuDAO();
	
	@Override
	public List<Menu> listar(int idrol) {
		// TODO Auto-generated method stub
		return dao.listar(idrol);
	}

	@Override
	public List<Menu> listarhijos(int idpadre) {
		// TODO Auto-generated method stub
		return dao.listarhijos(idpadre);
	}

}
