package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "Empleados")
public class Empleado implements Serializable {

	@Id
	@Column(name = "EmCodigo", nullable = false)
	private int codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EmCodigoDepartamento")
	private Departamento departamento;

	@Column(name = "EmFecNacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecNacimiento;

	@Column(name = "EmFecIngreso", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecIngreso;

	@Column(name = "EmSalario", nullable = false)
	private int salario;

	@Column(name = "EmComision", nullable = false)
	private int comision;

	@Column(name = "EmNombre",length = 20, nullable = false)
	private String nombre;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int codigo, Date fecNacimiento, Date fecIngreso, int salario, int comision, String nombre) {
		this.codigo = codigo;
		this.fecNacimiento = fecNacimiento;
		this.fecIngreso = fecIngreso;
		this.salario = salario;
		this.comision = comision;
		this.nombre = nombre;
	}

	public Empleado(int codigo, Departamento departamento, Date fecNacimiento, Date fecIngreso, int salario, int comision, String nombre) {
		this.codigo = codigo;
		this.departamento = departamento;
		this.fecNacimiento = fecNacimiento;
		this.fecIngreso = fecIngreso;
		this.salario = salario;
		this.comision = comision;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public Date getFecIngreso() {
		return fecIngreso;
	}

	public void setFecIngreso(Date fecIngreso) {
		this.fecIngreso = fecIngreso;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		Empleado other = (Empleado) obj;
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
		return "Empleado{" +
				"codigo=" + codigo +
				", departamento=" + departamento +
				", fecNacimiento=" + fecNacimiento +
				", fecIngreso=" + fecIngreso +
				", salario=" + salario +
				", comision=" + comision +
				", nombre='" + nombre + '\'' +
				'}';
	}
}
