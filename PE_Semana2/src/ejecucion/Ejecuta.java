package ejecucion;

import java.util.List;

import entidades.Empleado;
import model.ModelEmpleado;

public class Ejecuta {

	public static void main(String[] args) {
		
		ModelEmpleado model = new ModelEmpleado();
		List<Empleado> data = model.empleadoXcargo("Tecnico");
		
		for (Empleado empleado : data) {
			System.out.println(empleado.getIdEmpleado()+ "-" + empleado.getNombre());
		}
		
		int salida =model.CantidadEmpleadoXCargo("Tecnico",30 );
		System.out.println(salida);
		
		Empleado empl = model.empleadoEdadMaxima();
		System.out.println(empl.getNombre()+ " - "+ empl.getEdad());
	}
}
