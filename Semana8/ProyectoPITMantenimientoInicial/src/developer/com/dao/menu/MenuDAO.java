package developer.com.dao.menu;

import java.util.List;


import developer.com.bean.Menu;

public interface MenuDAO {
	public List<Menu> listar(int idrol);
	public List<Menu> listarhijos(int idpadre);
	
}
