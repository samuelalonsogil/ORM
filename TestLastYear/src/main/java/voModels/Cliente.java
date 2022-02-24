package voModels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "clDni", length = 9, nullable = false)
    String dni;

    @Column(name = "clNombre", length = 20, nullable = false)
    String nombre;

    @Column(name = "clApellidos", length = 30, nullable = false)
    String apellidos;

    @Column(name = "clDireccion", length = 50, nullable = false)
    String direccion;

    @Column(name = "clTelefono", nullable = false)
    int telefono;

    @Column(name = "clNumTarjeta", nullable = false)
    int numTarjeta;

    @OneToMany(mappedBy = "cliente")
    List<TarjetaEmbarque> tarjetasEmbarque;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, int telefono, int numTarjeta, List<TarjetaEmbarque> tarjetaEmbarque) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numTarjeta = numTarjeta;
        this.tarjetasEmbarque = tarjetaEmbarque;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public List<TarjetaEmbarque> getTarjetasEmbarque() {
        return tarjetasEmbarque;
    }

    public void setTarjetasEmbarque(List<TarjetaEmbarque> tarjetaEmbarque) {
        this.tarjetasEmbarque = tarjetaEmbarque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return telefono == cliente.telefono && numTarjeta == cliente.numTarjeta && Objects.equals(dni, cliente.dni) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellidos, cliente.apellidos) && Objects.equals(direccion, cliente.direccion) && Objects.equals(tarjetasEmbarque, cliente.tarjetasEmbarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellidos, direccion, telefono, numTarjeta, tarjetasEmbarque);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", numTarjeta=" + numTarjeta +
                ", tarjetaEmbarque=" + tarjetasEmbarque +
                '}';
    }
}
