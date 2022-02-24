package voModels;

import javax.persistence.*;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "tarjetasEmbarque")
public class TarjetaEmbarque {

    @Id
    @Column(name = "teCodigo", nullable = false)
    int teCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teDNI", nullable = false)
    Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teCodAsiento", nullable = false)
    Asiento asiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teCodVuelo", nullable = false)
    Vuelo vuelo;

    public TarjetaEmbarque() {
    }

    public TarjetaEmbarque(int teCodigo, Cliente cliente, Asiento asiento, Vuelo vuelo) {
        this.teCodigo = teCodigo;
        this.cliente = cliente;
        this.asiento = asiento;
        this.vuelo = vuelo;
    }

    public int getTeCodigo() {
        return teCodigo;
    }

    public void setTeCodigo(int teCodigo) {
        this.teCodigo = teCodigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarjetaEmbarque that = (TarjetaEmbarque) o;
        return teCodigo == that.teCodigo && Objects.equals(cliente, that.cliente) && Objects.equals(asiento, that.asiento) && Objects.equals(vuelo, that.vuelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teCodigo, cliente, asiento, vuelo);
    }

    @Override
    public String toString() {
        return "TarjetaEmbarque{" +
                "teCodigo=" + teCodigo +
                ", cliente=" + cliente +
                ", asiento=" + asiento +
                ", vuelo=" + vuelo +
                '}';
    }
}
