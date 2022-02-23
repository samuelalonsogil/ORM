package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Aviones")
public class Avion implements Serializable {
	@Id
	@Column(name = "avCodigo")
	private int codigo;
	@Column(name = "avModelo")
	private String modelo;
	
	@OneToMany(mappedBy = "avion", fetch = FetchType.LAZY)
	private List <Asiento> asientos = new ArrayList<Asiento>();
	
	@OneToMany(mappedBy = "avion", fetch = FetchType.LAZY)
	private List <Vuelo> vuelos = new ArrayList<Vuelo>();

	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avion(int codigo, String modelo, List<Asiento> asientos, List<Vuelo> vuelos) {
		super();
		this.codigo = codigo;
		this.modelo = modelo;
		this.asientos = asientos;
		this.vuelos = vuelos;
	}

	public Avion(int codigo, String modelo) {
		super();
		this.codigo = codigo;
		this.modelo = modelo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Avion other = (Avion) obj;
		if (codigo != other.codigo)
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avion [codigo=" + codigo + ", modelo=" + modelo + "]";
	}
	
	

}
