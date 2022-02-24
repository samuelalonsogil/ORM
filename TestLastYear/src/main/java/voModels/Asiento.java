package voModels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "asientos")
public class Asiento {

    @Id
    @Column(name = "asCodigo", nullable = false)
    int codigo;

    @Column(name = "asFila", nullable = false)
    int fila;

    @Column(name = "asColumna", nullable = false)
    int columna;

    @Column(name = "asLibre", nullable = false)
    boolean libre;

    @OneToMany(mappedBy = "asiento")
    List<TarjetaEmbarque> tarjetaEmbarque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asCodAvion", nullable = false)
    Avion avion;

    public Asiento() {
    }

    public Asiento(int codigo, int fila, int columna, boolean libre, List<TarjetaEmbarque> tarjetaEmbarque, Avion avion) {
        this.codigo = codigo;
        this.fila = fila;
        this.columna = columna;
        this.libre = libre;
        this.tarjetaEmbarque = tarjetaEmbarque;
        this.avion = avion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public List<TarjetaEmbarque> getTarjetaEmbarque() {
        return tarjetaEmbarque;
    }

    public void setTarjetaEmbarque(List<TarjetaEmbarque> tarjetaEmbarque) {
        this.tarjetaEmbarque = tarjetaEmbarque;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asiento asiento = (Asiento) o;
        return codigo == asiento.codigo && fila == asiento.fila && columna == asiento.columna && libre == asiento.libre && Objects.equals(tarjetaEmbarque, asiento.tarjetaEmbarque) && Objects.equals(avion, asiento.avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fila, columna, libre, tarjetaEmbarque, avion);
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "codigo=" + codigo +
                ", fila=" + fila +
                ", columna=" + columna +
                ", libre=" + libre +
                ", tarjetaEmbarque=" + tarjetaEmbarque +
                ", avion=" + avion +
                '}';
    }
}
