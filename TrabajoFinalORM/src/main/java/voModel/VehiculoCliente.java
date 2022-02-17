package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "VehiculosClientes")
public class VehiculoCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "vcId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idVehiculoCliente;

    @Column(name = "vcDNI")
    private String dni;

    @Column(name = "vcDias")
    private int dias;

    @Column(name = "vcSeguro")
    private String seguro;

    @Column(name = "vcPrecio")
    private int precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vcMatricula")
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vcDni")
    private Cliente cliente;

    public VehiculoCliente() {}

    public VehiculoCliente(int idVehiculoCliente, String dni, int dias, String seguro, int precio, Vehiculo vehiculo, Cliente cliente) {
        this.idVehiculoCliente = idVehiculoCliente;
        this.dni = dni;
        this.dias = dias;
        this.seguro = seguro;
        this.precio = precio;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public int getIdVehiculoCliente() {
        return idVehiculoCliente;
    }

    public void setIdVehiculoCliente(int idVehiculoCliente) {
        this.idVehiculoCliente = idVehiculoCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoCliente that = (VehiculoCliente) o;
        return idVehiculoCliente == that.idVehiculoCliente && dias == that.dias && precio == that.precio && Objects.equals(dni, that.dni) && Objects.equals(seguro, that.seguro) && Objects.equals(vehiculo, that.vehiculo) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVehiculoCliente, dni, dias, seguro, precio, vehiculo, cliente);
    }

    @Override
    public String toString() {
        return "VehiculoCliente{" +
                "idVehiculoCliente=" + idVehiculoCliente +
                ", dni='" + dni + '\'' +
                ", dias=" + dias +
                ", seguro='" + seguro + '\'' +
                ", precio=" + precio +
                ", vehiculo=" + vehiculo +
                ", cliente=" + cliente +
                '}';
    }
}
