package voModels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "aeropuertos")
public class Aeropuerto {

    @Id
    @Column(name = "aeCodigo", nullable = false)
    int codigo;

    @Column(name = "aeNombre", length = 50, nullable = false)
    String nombre;

    @Column(name = "aeLocalidad", length = 30, nullable = false)
    String localidad;

    @Column(name = "aePais", length = 30, nullable = false)
    String pais;

    @OneToMany(mappedBy = "origen")
    List<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "destino")
    List<Vuelo> vuelosDestino;

    public Aeropuerto() {
    }

    public Aeropuerto(int codigo, String nombre, String localidad, String pais, List<Vuelo> vuelosOrigen, List<Vuelo> vuelosDestino) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.pais = pais;
        this.vuelosOrigen = vuelosOrigen;
        this.vuelosDestino = vuelosDestino;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Vuelo> getVuelosOrigen() {
        return vuelosOrigen;
    }

    public void setVuelosOrigen(List<Vuelo> vuelosOrigen) {
        this.vuelosOrigen = vuelosOrigen;
    }

    public List<Vuelo> getVuelosDestino() {
        return vuelosDestino;
    }

    public void setVuelosDestino(List<Vuelo> vuelosDestino) {
        this.vuelosDestino = vuelosDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeropuerto that = (Aeropuerto) o;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre) && Objects.equals(localidad, that.localidad) && Objects.equals(pais, that.pais) && Objects.equals(vuelosOrigen, that.vuelosOrigen) && Objects.equals(vuelosDestino, that.vuelosDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, localidad, pais, vuelosOrigen, vuelosDestino);
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", pais='" + pais + '\'' +
                ", vuelosOrigen=" + vuelosOrigen +
                ", vuelosDestino=" + vuelosDestino +
                '}';
    }
}
