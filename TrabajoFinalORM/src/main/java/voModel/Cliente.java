package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "clDni")
    private String dni;

    @Column(name = "clNombre")
    private String nombre;

    @Column(name = "clDireccion")
    private String direccion;

    @Column(name = "clCiudad")
    private String ciudad;

    @Column(name = "clCodigoPostal")
    private String codigoPostal;

    @Column(name = "clProvincia")
    private String provincia;

    @Column(name = "clTelefono")
    private String telefono;

    @Column(name = "clNumTarjeta")
    private String numTarjeta;

    @OneToMany(mappedBy = "cliente")
    private List<VehiculoCliente> vehiculoClientes;

    public Cliente() {}

    public Cliente(String dni, String nombre, String direccion, String ciudad, String codigoPostal, String provincia, String telefono, String numTarjeta, List<VehiculoCliente> vehiculoClientes) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.telefono = telefono;
        this.numTarjeta = numTarjeta;
        this.vehiculoClientes = vehiculoClientes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public List<VehiculoCliente> getVehiculoClientes() {
        return vehiculoClientes;
    }

    public void setVehiculoClientes(List<VehiculoCliente> vehiculoClientes) {
        this.vehiculoClientes = vehiculoClientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni) && Objects.equals(nombre, cliente.nombre) && Objects.equals(direccion, cliente.direccion) && Objects.equals(ciudad, cliente.ciudad) && Objects.equals(codigoPostal, cliente.codigoPostal) && Objects.equals(provincia, cliente.provincia) && Objects.equals(telefono, cliente.telefono) && Objects.equals(numTarjeta, cliente.numTarjeta) && Objects.equals(vehiculoClientes, cliente.vehiculoClientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, direccion, ciudad, codigoPostal, provincia, telefono, numTarjeta, vehiculoClientes);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", vehiculoClientes=" + vehiculoClientes +
                '}';
    }
}
