package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Clientes")
public class Cliente implements Serializable {

    @Id
    @Column(name = "clDni", length = 9, nullable = false)
    private String dni;

    @Column(name = "clNombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "clDireccion", length = 50, nullable = false)
    private String direccion;

    @Column(name = "clCiudad", length = 20, nullable = false)
    private String ciudad;

    @Column(name = "clCodigoPostal", nullable = false)
    private int codigoPostal;

    @Column(name = "clProvincia", length = 20, nullable = false)
    private String provincia;

    @Column(name = "clTelefono")
    private int telefono;

    @Column(name = "clNumTarjeta",length = 16, nullable = false)
    private String numTarjeta;

    @OneToMany(mappedBy = "cliente")
    private List<VehiculoCliente> vehiculoClientes;

    public Cliente() {}

    public Cliente(String dni, String nombre, String direccion, String ciudad, int codigoPostal, String provincia, int telefono, String numTarjeta, List<VehiculoCliente> vehiculoClientes) {
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
        return codigoPostal == cliente.codigoPostal && telefono == cliente.telefono && Objects.equals(dni, cliente.dni) && Objects.equals(nombre, cliente.nombre) && Objects.equals(direccion, cliente.direccion) && Objects.equals(ciudad, cliente.ciudad) && Objects.equals(provincia, cliente.provincia) && Objects.equals(numTarjeta, cliente.numTarjeta) && Objects.equals(vehiculoClientes, cliente.vehiculoClientes);
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
                ", codigoPostal=" + codigoPostal +
                ", provincia='" + provincia + '\'' +
                ", telefono=" + telefono +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", vehiculoClientes=" + vehiculoClientes +
                '}';
    }
}
