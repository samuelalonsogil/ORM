package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Proyectos")
public class Proyecto implements Serializable {
    @Id
    @Column(name = "prCodigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "prNombre", length = 45, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "proyectos")
    private List<Trabajador> trabajadores;

    public Proyecto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Proyecto(int codigo, String nombre) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Proyecto(String nombre) {
        this.nombre = nombre;
    }

    public Proyecto(int codigo, String nombre, List<Trabajador> trabajadores) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.trabajadores = trabajadores;
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

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
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
        Proyecto other = (Proyecto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Proyecto [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}
