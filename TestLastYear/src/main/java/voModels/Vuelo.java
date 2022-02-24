package voModels;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @Column(name = "vuCodigo", nullable = false)
    int codigo;

    @Column(name = "vuFecSalida", nullable = false)
    @Temporal(TemporalType.DATE)
    Date fechaSalida;

    @Column(name = "vuFecLlegada", nullable = false)
    @Temporal(TemporalType.DATE)
    Date fechaLlegada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vuCodAvion", nullable = false)
    Avion avion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vuOrigen", nullable = false)
    Aeropuerto origen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vuDestino", nullable = false)
    Aeropuerto destino;

    @OneToMany(mappedBy = "vuelo")
    List<TarjetaEmbarque> tarjetasEmbarque;

    public Vuelo() {
    }

    public Vuelo(int codigo, Date fechaSalida, Date fechaLlegada, Avion avion, Aeropuerto origen, Aeropuerto destino, List<TarjetaEmbarque> tarjetasEmbarque) {
        this.codigo = codigo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.tarjetasEmbarque = tarjetasEmbarque;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public List<TarjetaEmbarque> getTarjetasEmbarque() {
        return tarjetasEmbarque;
    }

    public void setTarjetasEmbarque(List<TarjetaEmbarque> tarjetasEmbarque) {
        this.tarjetasEmbarque = tarjetasEmbarque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return codigo == vuelo.codigo && Objects.equals(fechaSalida, vuelo.fechaSalida) && Objects.equals(fechaLlegada, vuelo.fechaLlegada) && Objects.equals(avion, vuelo.avion) && Objects.equals(origen, vuelo.origen) && Objects.equals(destino, vuelo.destino) && Objects.equals(tarjetasEmbarque, vuelo.tarjetasEmbarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fechaSalida, fechaLlegada, avion, origen, destino, tarjetasEmbarque);
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigo=" + codigo +
                ", fechaSalida=" + fechaSalida +
                ", fechaLlegada=" + fechaLlegada +
                ", avion=" + avion +
                ", origen=" + origen +
                ", destino=" + destino +
                ", tarjetasEmbarque=" + tarjetasEmbarque +
                '}';
    }
}
