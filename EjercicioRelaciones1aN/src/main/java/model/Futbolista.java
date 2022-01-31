package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Futbolistas")
public class Futbolista implements Serializable {
    @Id
    @Column(name = "fuNumFicha")
    private int numFicha;


    @Column(name = "fuNombre", length = 15)
    private String nombre;

    @Column(name = "fuApellidos", length = 45)
    private String apellidos;

    @Column(name = "fuFecNacimiento")
    private Date fecNacimiento;

    @Column(name = "fuPeso")
    private double peso;

    @Column(name = "fuAltura")
    private int altura;

    @Column(name = "fuSueldo")
    private int sueldo;

    public Futbolista() {
    }

    public Futbolista(int numFicha, String nombre, String apellidos, Date fecNacimiento, double peso, int altura, int sueldo) {
        this.numFicha = numFicha;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecNacimiento = fecNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.sueldo = sueldo;
    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
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

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista that = (Futbolista) o;
        return numFicha == that.numFicha && Double.compare(that.peso, peso) == 0 && altura == that.altura && sueldo == that.sueldo && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(fecNacimiento, that.fecNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFicha, nombre, apellidos, fecNacimiento, peso, altura, sueldo);
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "numFicha=" + numFicha +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecNacimiento=" + fecNacimiento +
                ", peso=" + peso +
                ", altura=" + altura +
                ", sueldo=" + sueldo +
                '}';
    }
}
