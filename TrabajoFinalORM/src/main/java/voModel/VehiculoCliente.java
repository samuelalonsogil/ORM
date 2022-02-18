package voModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "VehiculosClientes")
public class VehiculoCliente implements Serializable {

    @Id
    @Column(name = "vcId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculoCliente;

    @Column(name = "vcDias", nullable = false)
    private Integer dias;

    @Column(name = "vcSeguro", length = 20, nullable = false)
    private String seguro;

    @Column(name = "vcPrecio", nullable = false)
    private Integer precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vcMatricula", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vcDni", nullable = false)
    private Cliente cliente;

    public VehiculoCliente() {}

    public VehiculoCliente(Integer idVehiculoCliente, Integer dias, String seguro, Integer precio, Vehiculo vehiculo, Cliente cliente) {
        this.idVehiculoCliente = idVehiculoCliente;
        this.dias = dias;
        this.seguro = seguro;
        this.precio = precio;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public Integer getIdVehiculoCliente() {
        return idVehiculoCliente;
    }

    public void setIdVehiculoCliente(Integer idVehiculoCliente) {
        this.idVehiculoCliente = idVehiculoCliente;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
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
        return Objects.equals(idVehiculoCliente, that.idVehiculoCliente) && Objects.equals(dias, that.dias) && Objects.equals(seguro, that.seguro) && Objects.equals(precio, that.precio) && Objects.equals(vehiculo, that.vehiculo) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVehiculoCliente, dias, seguro, precio, vehiculo, cliente);
    }

    @Override
    public String toString() {
        return "VehiculoCliente{" +
                "idVehiculoCliente=" + idVehiculoCliente +
                ", dias=" + dias +
                ", seguro='" + seguro + '\'' +
                ", precio=" + precio +
                ", vehiculo=" + vehiculo +
                ", cliente=" + cliente +
                '}';
    }
}
