package action;

import javax.faces.bean.ManagedBean;

import model.CarreraModel;
import entidades.Carrera;


@ManagedBean
public class CarreraAction {

	private Carrera carrera;
	
	
	public CarreraAction() {
			carrera = new Carrera();
	}
	
	public String registra(){

		CarreraModel m = new CarreraModel();
		m.registrar(carrera);
		
		return "/ui/registraCarrera.jsf";
	}
	public String salir(){

		return "/ui/principal.jsf";
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
