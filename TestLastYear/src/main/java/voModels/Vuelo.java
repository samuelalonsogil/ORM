package voModels;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @Column(name = "vuCodigo")
    int codigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vuCodAvion")
    Avion codAvion;

    @Column(name = "vuFecSalida")
    Date fechaSalida;

    @Column(name = "vuFecLlegada")
    Date fechaLlegada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vuOrigen")
    Aeropuerto origen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vuDestino")
    Aeropuerto destino;

    @OneToMany(mappedBy = "vuelo")
    List<TarjetaEmbarque> tarjetasEmbarque;

    public Vuelo() {
    }

    public Vuelo(int codigo, Avion codAvion, Date fechaSalida, Date fechaLlegada, Aeropuerto origen, Aeropuerto destino, List<TarjetaEmbarque> tarjetasEmbarque) {
        this.codigo = codigo;
        this.codAvion = codAvion;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
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

    public Avion getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(Avion codAvion) {
        this.codAvion = codAvion;
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
        return codigo == vuelo.codigo && Objects.equals(codAvion, vuelo.codAvion) && Objects.equals(fechaSalida, vuelo.fechaSalida) && Objects.equals(fechaLlegada, vuelo.fechaLlegada) && Objects.equals(origen, vuelo.origen) && Objects.equals(destino, vuelo.destino) && Objects.equals(tarjetasEmbarque, vuelo.tarjetasEmbarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, codAvion, fechaSalida, fechaLlegada, origen, destino, tarjetasEmbarque);
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigo=" + codigo +
                ", codAvion=" + codAvion +
                ", fechaSalida=" + fechaSalida +
                ", fechaLlegada=" + fechaLlegada +
                ", origen=" + origen +
                ", destino=" + destino +
                ", tarjetasEmbarque=" + tarjetasEmbarque +
                '}';
    }
}
