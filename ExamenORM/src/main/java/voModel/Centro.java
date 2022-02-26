package voModel;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Centros")
public class Centro implements Serializable {

	@Id
	@Column(name = "CeCodigo", nullable = false)
	private int codigo;

	@Column(name = "CeNombre", length = 30,nullable = false)
	private String nombre;

	@Column(name = "CeDireccion", length = 100,nullable = false)
	private String direccion;
	
	@OneToMany(mappedBy = "centro")
	private List<Departamento> departamentos = new ArrayList<Departamento>();

	
	public Centro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Centro(int codigo, String nombre, String direccion, List<Departamento> departamentos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.departamentos = departamentos;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
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
		Centro other = (Centro) obj;
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
