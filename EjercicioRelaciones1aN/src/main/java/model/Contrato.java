package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Contratos")
public class Contrato implements Serializable {

    @Id
    @Column(name = "coNumContrato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numContrato;

    @Column(name = "coFechaContrato", updatable = false)
    private Date fechaContrato;

    @Column(name = "coDuracion")
    private int duracion;

    @Column(name = "coFichaAnual")
    private int fichaAnual;

    @Column(name = "coClausula")
    private int clausula;

    @Column(name = "coNbEquipo", length = 50)
    private String nbEquipo;

    @Column(name = "coNumFicha")
    private int numFicha;

    public Contrato() {
    }

    public Contrato(int numContrato, Date fechaContrato, int duracion, int fichaAnual, int clausula, String nbEquipo, int numFicha) {
        this.numContrato = numContrato;
        this.fechaContrato = fechaContrato;
        this.duracion = duracion;
        this.fichaAnual = fichaAnual;
        this.clausula = clausula;
        this.nbEquipo = nbEquipo;
        this.numFicha = numFicha;
    }

    public Contrato(Date fechaContrato, int duracion, int fichaAnual, int clausula, String nbEquipo, int numFicha) {
        this.fechaContrato = fechaContrato;
        this.duracion = duracion;
        this.fichaAnual = fichaAnual;
        this.clausula = clausula;
        this.nbEquipo = nbEquipo;
        this.numFicha = numFicha;
    }

    public int getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(int numContrato) {
        this.numContrato = numContrato;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getFichaAnual() {
        return fichaAnual;
    }

    public void setFichaAnual(int fichaAnual) {
        this.fichaAnual = fichaAnual;
    }

    public int getClausula() {
        return clausula;
    }

    public void setClausula(int clausula) {
        this.clausula = clausula;
    }

    public String getNbEquipo() {
        return nbEquipo;
    }

    public void setNbEquipo(String nbEquipo) {
        this.nbEquipo = nbEquipo;
    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return numContrato == contrato.numContrato && duracion == contrato.duracion && fichaAnual == contrato.fichaAnual && clausula == contrato.clausula && numFicha == contrato.numFicha && Objects.equals(fechaContrato, contrato.fechaContrato) && Objects.equals(nbEquipo, contrato.nbEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numContrato, fechaContrato, duracion, fichaAnual, clausula, nbEquipo, numFicha);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "numContrato=" + numContrato +
                ", fechaContrato=" + fechaContrato +
                ", duracion=" + duracion +
                ", fichaAnual=" + fichaAnual +
                ", clausula=" + clausula +
                ", nbEquipo='" + nbEquipo + '\'' +
                ", numFicha=" + numFicha +
                '}';
    }
}
