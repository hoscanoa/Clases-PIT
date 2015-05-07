package entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="tb_cargo")

public class Cargo {
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cargo")
	private int idCargo;
	
	private int id_cargo;
	private String descripcion;
	
	@OneToMany(mappedBy="cargo")//con la clase cargo
	private List<Empleado> lstEmpleado;
	
	public int getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
