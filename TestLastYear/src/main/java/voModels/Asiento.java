package voModels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "asientos")
public class Asiento {

    @Id
    @Column(name = "asCodigo")
    int codigo;

    @Column(name = "asCodAvion")
    int codAvion;

    @Column(name = "asFila")
    int fila;

    @Column(name = "asColumna")
    int columna;

    @Column(name = "asLibre")
    boolean libre;

    @OneToMany(mappedBy = "asiento")
    List<TarjetaEmbarque> tarjetaEmbarque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "avCodigo")
    Avion avion;

    public Asiento() {
    }

    public Asiento(int codigo, int codAvion, int fila, int columna, boolean libre, List<TarjetaEmbarque> tarjetaEmbarque, Avion avion) {
        this.codigo = codigo;
        this.codAvion = codAvion;
        this.fila = fila;
        this.columna = columna;
        this.libre = libre;
        this.tarjetaEmbarque = tarjetaEmbarque;
        this.avion = avion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asiento asiento = (Asiento) o;
        return codigo == asiento.codigo && codAvion == asiento.codAvion && fila == asiento.fila && columna == asiento.columna && libre == asiento.libre && Objects.equals(tarjetaEmbarque, asiento.tarjetaEmbarque) && Objects.equals(avion, asiento.avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, codAvion, fila, columna, libre, tarjetaEmbarque, avion);
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "codigo=" + codigo +
                ", codAvion=" + codAvion +
                ", fila=" + fila +
                ", columna=" + columna +
                ", libre=" + libre +
                ", tarjetaEmbarque=" + tarjetaEmbarque +
                ", avion=" + avion +
                '}';
    }
}
