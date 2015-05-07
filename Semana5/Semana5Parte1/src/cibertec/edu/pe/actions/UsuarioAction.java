package cibertec.edu.pe.actions;

import cibertec.edu.pe.beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

public class UsuarioAction extends ActionSupport {
	
	private Usuario usuariobean;

	
	public String Validar(){
		String ir="denegado";
		if(usuariobean.getLogin().equals("cibertec") &&
				usuariobean.getPwd().equals("123")){
			ir ="exito";
			usuariobean.setNombre("ANA MARIA");
		}		
		return ir;		
	}
	
	public void setUsuariobean(Usuario usuariobean) {
		this.usuariobean = usuariobean;
	}

	public Usuario getUsuariobean() {
		return usuariobean;
	}

}
