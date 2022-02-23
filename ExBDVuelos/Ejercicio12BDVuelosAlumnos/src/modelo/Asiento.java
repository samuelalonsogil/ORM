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
@Table(name ="Asientos")
public class Asiento implements Serializable {
	
	@Id
	@Column(name = "asCodigo")
	private int codigo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asCodAvion")
	private Avion avion;
	
	@Column(name = "asFila")
	private int fila;
	@Column(name = "asColumna")
	private int columna;
	@Column(name = "asLibre")
	private Boolean libre;
	
	public Asiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asiento(int codigo, Avion avion, int fila, int columna, Boolean libre) {
		super();
		this.codigo = codigo;
		this.avion = avion;
		this.fila = fila;
		this.columna = columna;
		this.libre = libre;
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

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Boolean getLibre() {
		return libre;
	}

	public void setLibre(Boolean libre) {
		this.libre = libre;
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
		Asiento other = (Asiento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asiento [codigo=" + codigo + ", avion=" + avion + ", "
				+ "fila=" + fila + ", columna=" + columna + ", libre="
				+ libre + "]";
	}
}
