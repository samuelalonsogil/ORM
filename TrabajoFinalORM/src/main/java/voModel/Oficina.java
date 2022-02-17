package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Oficinas")
public class Oficina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idOficina")
    private int idOficina;

    @Column(name = "ofDireccion")
    private String direccion;

    @Column(name = "ofCiudad")
    private String ciudad;

    @Column(name = "ofCodigoPostal")
    private int codigoPostal;

    @Column(name = "ofProvincia")
    private String provinica;

    @Column(name = "ofTelefono")
    private String telefono;

    @OneToMany(mappedBy = "oficina")
    private List<Vehiculo> oficinas;

    public Oficina() {}

    public Oficina(int idOficina, String direccion, String ciudad, int codigoPostal, String provinica, String telefono, List<Vehiculo> oficinas) {
        this.idOficina = idOficina;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.provinica = provinica;
        this.telefono = telefono;
        this.oficinas = oficinas;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvinica() {
        return provinica;
    }

    public void setProvinica(String provinica) {
        this.provinica = provinica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Vehiculo> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<Vehiculo> oficinas) {
        this.oficinas = oficinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oficina oficina = (Oficina) o;
        return idOficina == oficina.idOficina && codigoPostal == oficina.codigoPostal && Objects.equals(direccion, oficina.direccion) && Objects.equals(ciudad, oficina.ciudad) && Objects.equals(provinica, oficina.provinica) && Objects.equals(telefono, oficina.telefono) && Objects.equals(oficinas, oficina.oficinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOficina, direccion, ciudad, codigoPostal, provinica, telefono, oficinas);
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "idOficina=" + idOficina +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", provinica='" + provinica + '\'' +
                ", telefono='" + telefono + '\'' +
                ", oficinas=" + oficinas +
                '}';
    }
}
