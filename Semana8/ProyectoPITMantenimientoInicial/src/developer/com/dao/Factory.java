package developer.com.dao;


import developer.com.dao.menu.MenuDAO;



import developer.com.dao.usuario.UsuarioDAO;

public abstract class Factory {	
	public static final int TIPO_SQL_SERVER = 1;
	public static final int TIPO_MYSQL = 2;

	
	public abstract MenuDAO getMenuDAO();
	
	public abstract UsuarioDAO getUsuarioDAO();
	
	
	public static Factory getFactory(int tipo) {
		switch (tipo) {
			case TIPO_SQL_SERVER :
				return new SQLServerFactory();
			default :
				return null;
		}
	}

}
