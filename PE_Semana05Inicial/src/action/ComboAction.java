package action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.CarreraModel;
import entidades.Carrera;


@ManagedBean
public class ComboAction {

	private List<Carrera> lstCarreras;

	public List<Carrera> getLstCarreras() {
		lstCarreras = new CarreraModel().listaCarrera();
		return lstCarreras;
	}

	public void setLstCarreras(List<Carrera> lstCarreras) {
		this.lstCarreras = lstCarreras;
	}
	
	
	
}
