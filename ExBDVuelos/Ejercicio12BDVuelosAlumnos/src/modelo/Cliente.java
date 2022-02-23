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
@Table(name ="Clientes")
public class Cliente implements Serializable {
	
	@Id
	@Column(name = "clDNI", length = 9)
	private String dni;
	
	@Column(name = "clNombre")
	private String nombre;
	
	@Column(name = "clApellidos")
	private String apellidos;
	
	@Column(name = "clDireccion")
	private String direccion;
	
	@Column(name = "clTelefono")
	private int telefono;  
	
	@Column(name = "clNumTarjeta")
	private int numTarjeta;
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<TarjetaEmbarque> tarjetasEmbarque = new ArrayList<TarjetaEmbarque>();

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String dni, String nombre, String apellidos, String direccion, int telefono, int numTarjeta,
			List<TarjetaEmbarque> tarjetasEmbarque) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.numTarjeta = numTarjeta;
		this.tarjetasEmbarque = tarjetasEmbarque;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public List<TarjetaEmbarque> getTarjetasEmbarque() {
		return tarjetasEmbarque;
	}

	public void setTarjetasEmbarque(List<TarjetaEmbarque> tarjetasEmbarque) {
		this.tarjetasEmbarque = tarjetasEmbarque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", numTarjeta=" + numTarjeta + "]";
	}
}
