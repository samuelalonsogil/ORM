package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Trabajadores")
public class Trabajador implements Serializable {
    @Id
    @Column(name = "trCodigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "trNombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "trSalario", nullable = false)
    private int salario;

    @ManyToMany(targetEntity = Proyecto.class)
    private List<Proyecto> proyectos;

    public Trabajador() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Trabajador(String nombre, int salario, List<Proyecto> proyectos) {
        super();
        this.nombre = nombre;
        this.salario = salario;
        this.proyectos = proyectos;
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

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
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
        Trabajador other = (Trabajador) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Trabajador [codigo=" + codigo + ", nombre=" + nombre + ", salario=" + salario + "]";
    }

}
