package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Aeropuertos")
public class Aeropuerto implements Serializable {
	@Id
	@Column(name = "aeCodigo")
	private int codigo;
	@Column(name = "aeNombre")
	private String nombre;
	@Column(name = "aeLocalidad")
	private String localidad;
	@Column(name = "aePais")
	private String pais;
	
	@OneToMany (mappedBy = "origen")
	private List <Vuelo> vuelosOrigen = new ArrayList <Vuelo>();
	
	@OneToMany (mappedBy = "destino")
	private List <Vuelo> vuelosDestino = new ArrayList <Vuelo>();

	public Aeropuerto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aeropuerto(int codigo, String nombre, String localidad, String pais, List<Vuelo> vuelosOrigen,
			List<Vuelo> vuelosDestino) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.localidad = localidad;
		this.pais = pais;
		this.vuelosOrigen = vuelosOrigen;
		this.vuelosDestino = vuelosDestino;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Vuelo> getVuelosOrigen() {
		return vuelosOrigen;
	}

	public void setVuelosOrigen(List<Vuelo> vuelosOrigen) {
		this.vuelosOrigen = vuelosOrigen;
	}

	public List<Vuelo> getVuelosDestino() {
		return vuelosDestino;
	}

	public void setVuelosDestino(List<Vuelo> vuelosDestino) {
		this.vuelosDestino = vuelosDestino;
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
		Aeropuerto other = (Aeropuerto) obj;
		if (codigo != other.codigo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aeropuerto [codigo=" + codigo + ", nombre=" + nombre + ", localidad=" + 
	localidad + ", pais=" + pais
				+ "]";
	}
	
	
	
	
}
