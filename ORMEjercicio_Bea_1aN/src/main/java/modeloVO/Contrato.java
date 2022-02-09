package modeloVO;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @Column(name = "coNumContrato", nullable = false)
    private Integer numContrato;

    @Column(name = "coFecContrato", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecContrato;
    @Column(name = "coDuracion", nullable = false)
    private int duracion;
    @Column(name ="coFichaAnual", nullable = false)
    private int fichaAnual;
    @Column(name = "coClausula", nullable = false)
    private  int clausula;

    @ManyToOne
    @JoinColumn(name="coNbequipo")
    private Equipo equi;

    @ManyToOne
    @JoinColumn(name = "coNumFicha")
    private Futbolista futbol;

    public Contrato() {
    }

    public Contrato(Integer numContrato, Date fecContrato, int duracion, int clausula, Equipo equi, Futbolista futbol) {
        this.numContrato = numContrato;
        this.fecContrato = fecContrato;
        this.duracion = duracion;
        this.clausula = clausula;
        this.equi = equi;
        this.futbol = futbol;
    }

    public Contrato(Integer numContrato, Date fecContrato, int duracion, int fichaAnual, int clausula, Equipo equi, Futbolista futbol) {
        this.numContrato = numContrato;
        this.fecContrato = fecContrato;
        this.duracion = duracion;
        this.fichaAnual = fichaAnual;
        this.clausula = clausula;
        this.equi = equi;
        this.futbol = futbol;
    }

    public Integer getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(Integer numContrato) {
        this.numContrato = numContrato;
    }

    public Date getFecContrato() {
        return fecContrato;
    }

    public void setFecContrato(Date fecContrato) {
        this.fecContrato = fecContrato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getClausula() {
        return clausula;
    }

    public void setClausula(int clausula) {
        this.clausula = clausula;
    }

    public Equipo getEqui() {
        return equi;
    }

    public void setEqui(Equipo equi) {
        this.equi = equi;
    }

    public Futbolista getFutbol() {
        return futbol;
    }

    public void setFutbol(Futbolista futbol) {
        this.futbol = futbol;
    }

    public int getFichaAnual() {
        return fichaAnual;
    }

    public void setFichaAnual(int fichaAnual) {
        this.fichaAnual = fichaAnual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return duracion == contrato.duracion && clausula == contrato.clausula && numContrato.equals(contrato.numContrato) && fecContrato.equals(contrato.fecContrato) && equi.equals(contrato.equi) && futbol.equals(contrato.futbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numContrato, fecContrato, duracion, clausula, equi, futbol);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "numContrato=" + numContrato +
                ", fecContrato=" + fecContrato +
                ", duracion=" + duracion +
                ", fichaAnual=" + fichaAnual +
                ", clausula=" + clausula +
                ", equi=" + equi +
                ", futbol=" + futbol +
                '}';
    }
}
