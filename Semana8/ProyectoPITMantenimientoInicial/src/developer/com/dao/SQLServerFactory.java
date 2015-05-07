package developer.com.dao;


import developer.com.dao.menu.MenuDAO;

import developer.com.dao.menu.SqlServerMenuDAO;


import developer.com.dao.usuario.SqlServerUsuarioDAO;
import developer.com.dao.usuario.UsuarioDAO;

public class SQLServerFactory extends Factory {

	
	@Override
	public MenuDAO getMenuDAO() {		
		return new SqlServerMenuDAO();
	}

	

	@Override
	public UsuarioDAO getUsuarioDAO() {
		
		return new SqlServerUsuarioDAO();
	}

}
