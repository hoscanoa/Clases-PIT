package action;

import javax.faces.bean.ManagedBean;

import model.AlumnoModel;
import entidades.Alumno;


@ManagedBean
public class AlumnoAction {
	
	public AlumnoAction() {
		alumno = new Alumno();
	}

	private Alumno alumno;
	
		public String registra(){
			AlumnoModel model = new AlumnoModel();
			model.registrar(alumno);
		
		return "/ui/registraAlumno.jsf";
}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
}
