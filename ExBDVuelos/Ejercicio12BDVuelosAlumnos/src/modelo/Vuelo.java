package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Vuelos")
public class Vuelo implements Serializable {
	@Id
	@Column(name = "vuCodigo")
	private int codigo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vuCodAvion")
	private Avion avion;
	
	@Column(name = "vuFecSalida")
	private Date fecSalida;
	@Column(name = "vuFecLlegada")
	private Date fecLlegada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vuOrigen")
	private Aeropuerto origen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vuDestino")
	private Aeropuerto destino;

	public Vuelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vuelo(int codigo, Avion avion, Date fecSalida, Date fecLlegada, Aeropuerto origen, Aeropuerto destino) {
		super();
		this.codigo = codigo;
		this.avion = avion;
		this.fecSalida = fecSalida;
		this.fecLlegada = fecLlegada;
		this.origen = origen;
		this.destino = destino;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Date getFecSalida() {
		return fecSalida;
	}

	public void setFecSalida(Date fecSalida) {
		this.fecSalida = fecSalida;
	}

	public Date getFecLlegada() {
		return fecLlegada;
	}

	public void setFecLlegada(Date fecLlegada) {
		this.fecLlegada = fecLlegada;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Vuelo other = (Vuelo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vuelo [codigo=" + codigo   + "]";
	}
	
	
	

}
