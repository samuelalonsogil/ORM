package voModels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "aviones")
public class Avion {

    @Id
    @Column(name = "avCodigo", nullable = false)
    int codigo;

    @Column(name = "avModelo", length = 30, nullable = false)
    String modelo;

    @OneToMany(mappedBy = "avion")
    public List<Asiento> asientos;

    @OneToMany(mappedBy = "avion")
    public List<Vuelo> vuelos;

    public Avion() {
    }

    public Avion(int codigo, String modelo, List<Asiento> asientos, List<Vuelo> vuelos) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.asientos = asientos;
        this.vuelos = vuelos;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return codigo == avion.codigo && Objects.equals(modelo, avion.modelo) && Objects.equals(asientos, avion.asientos) && Objects.equals(vuelos, avion.vuelos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, modelo, asientos, vuelos);
    }

    @Override
    public String toString() {
        return "Avion{" +
                "codigo=" + codigo +
                ", modelo='" + modelo + '\'' +
                ", asientos=" + asientos +
                ", vuelos=" + vuelos +
                '}';
    }
}
