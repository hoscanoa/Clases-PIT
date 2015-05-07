package developer.com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import developer.com.bean.Menu;
import developer.com.bean.Usuario;
import developer.com.dao.Factory;
import developer.com.dao.SQLServerFactory;
import developer.com.dao.usuario.UsuarioDAO;
import developer.com.service.MenuImplementacion;
import developer.com.service.UsuarioImplementacion;

public class UsuarioAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuariobean;
	private List<Menu> menus;
	
	
	@Action(value="ALogueo",results={
			@Result(name="denegado",location="/index.jsp"),
			@Result(name="exito",location="/menu.jsp")
			})
	public String Loguear(){
		UsuarioImplementacion usuarioi=new UsuarioImplementacion();
		MenuImplementacion menui=new MenuImplementacion();
		usuariobean = usuarioi.Loguear(usuariobean);
		String ir="denegado";
		if(usuariobean==null)
			addActionError("Error de prueba");
		else{
			//addActionMessage("Usuario Coorecto");
			ir="exito";
			menus=menui.listar(usuariobean.getRolId());
		}
		
		return ir;
	}
	
	public void setUsuariobean(Usuario usuariobean) {
		this.usuariobean = usuariobean;
	}

	public Usuario getUsuariobean() {
		return usuariobean;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Menu> getMenus() {
		return menus;
	}

}
