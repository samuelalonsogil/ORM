package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "Departamentos")
public class Departamento implements Serializable {

	@Id
	@Column(name = "DeCodigo", nullable = false)
	private int codigo;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DeCodigoCentro")
	private Centro centro;

	@Column(name = "DeTipoDirector",length = 1, nullable = false)
	private String tipoDirector;

	@Column(name = "DePresupuesto", nullable = false)
	private double presupuesto;

	@Column(name = "DeNombre", length = 30, nullable = false)
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DeDirector")
	private  Empleado director;

	@OneToMany(mappedBy = "departamento")
	private List<Empleado> empleados;
	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departamento(int codigo, Centro centro, String tipoDirector, double presupuesto, String nombre,
			Empleado director, List<Empleado> empleados) {
		super();
		this.codigo = codigo;
		this.centro = centro;
		this.tipoDirector = tipoDirector;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
		this.director = director;
		this.empleados = empleados;
	}

	public Departamento(int codigo, String tipoDirector, double presupuesto, String nombre) {
		this.codigo = codigo;
		this.tipoDirector = tipoDirector;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public String getTipoDirector() {
		return tipoDirector;
	}
	public void setTipoDirector(String tipoDirector) {
		this.tipoDirector = tipoDirector;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Empleado getDirector() {
		return director;
	}
	public void setDirector(Empleado director) {
		this.director = director;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (codigo != other.codigo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	

}
