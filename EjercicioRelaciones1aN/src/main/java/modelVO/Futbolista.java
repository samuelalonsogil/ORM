package modelVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuNumFicha")
    private Equipo equipo;

    @OneToMany(mappedBy = "futb", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Contrato> contratos = new ArrayList<>();

    public Futbolista() {
    }

    public Futbolista(int numFicha, String nombre, String apellidos, Date fecNacimiento, double peso, int altura, int sueldo, Equipo equipo, List<Contrato> contratos) {

        this.numFicha = numFicha;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecNacimiento = fecNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.sueldo = sueldo;
        this.equipo = equipo;
        this.contratos = contratos;
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista that = (Futbolista) o;
        return numFicha == that.numFicha && Double.compare(that.peso, peso) == 0 && altura == that.altura && sueldo == that.sueldo && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(fecNacimiento, that.fecNacimiento) && Objects.equals(equipo, that.equipo) && Objects.equals(contratos, that.contratos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numFicha, nombre, apellidos, fecNacimiento, peso, altura, sueldo, equipo, contratos);
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
                ", equipo=" + equipo +
                ", contratos=" + contratos +
                '}';
    }
}
