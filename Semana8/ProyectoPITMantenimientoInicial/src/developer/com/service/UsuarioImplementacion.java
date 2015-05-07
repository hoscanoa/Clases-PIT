package developer.com.service;

import developer.com.bean.Usuario;
import developer.com.dao.Factory;
import developer.com.dao.SQLServerFactory;
import developer.com.dao.usuario.UsuarioDAO;

public class UsuarioImplementacion implements UsuarioDAO{

	Factory factory=SQLServerFactory.getFactory(1);
	UsuarioDAO dao=factory.getUsuarioDAO();
	@Override
	public Usuario Loguear(Usuario obj) {
		// TODO Auto-generated method stub
		return dao.Loguear(obj);
	}

}
