package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="TarjetasEmbarque")
public class TarjetaEmbarque implements Serializable {
	
	@Id
	@Column(name = "teCodigo")
	private int codEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teDni")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teCodAsiento")
	private Asiento asiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teCodVuelo")
	private Vuelo vuelo;
	
	

	public TarjetaEmbarque() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TarjetaEmbarque(int codEmbarque, Cliente cliente, Asiento asiento, Vuelo vuelo) {
		super();
		this.codEmbarque = codEmbarque;
		this.cliente = cliente;
		this.asiento = asiento;
		this.vuelo = vuelo;
	}



	public int getCodEmbarque() {
		return codEmbarque;
	}



	public void setCodEmbarque(int codEmbarque) {
		this.codEmbarque = codEmbarque;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Asiento getAsiento() {
		return asiento;
	}



	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}



	public Vuelo getVuelo() {
		return vuelo;
	}



	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codEmbarque;
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
		TarjetaEmbarque other = (TarjetaEmbarque) obj;
		if (codEmbarque != other.codEmbarque)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "TarjetaEmbarque [codEmbarque=" + codEmbarque + ", cliente=" + cliente + ", "
				+ "asiento=" + asiento
				+ ", vuelo=" + vuelo + "]";
	}
}
