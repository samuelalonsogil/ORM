package modelVO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Equipos")
public class Equipo implements Serializable {

    @Id
    @Column(name = "eqNombre", length = 50)
    private String nombre;

    @Column(name = "eqPresidente", length = 50)
    private String prsidente;

    @Column(name = "eqEstadio", length = 50)
    private String estadio;

    @Column(name = "eqAnhoFundacion")
    private Year anhoFundacion;

    @Column(name = "eqNumSocios")
    private int numSocios;

    //caundo no hay clave ajena se pone el mapped by con el nombre que se le dio en la tabla n
    @OneToMany(mappedBy = "equip", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Contrato> contratos = new ArrayList<>();

    

    public Equipo() {
    }

    public Equipo(String nombre, String prsidente, String estadio, Year anhoFundacion, int numSocios, List<Contrato> contratos) {
        this.nombre = nombre;
        this.prsidente = prsidente;
        this.estadio = estadio;
        this.anhoFundacion = anhoFundacion;
        this.numSocios = numSocios;
        this.contratos = contratos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrsidente() {
        return prsidente;
    }

    public void setPrsidente(String prsidente) {
        this.prsidente = prsidente;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Year getAnhoFundacion() {
        return anhoFundacion;
    }

    public void setAnhoFundacion(Year anhoFundacion) {
        this.anhoFundacion = anhoFundacion;
    }

    public int getNumSocios() {
        return numSocios;
    }

    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return numSocios == equipo.numSocios && Objects.equals(nombre, equipo.nombre) && Objects.equals(prsidente, equipo.prsidente) && Objects.equals(estadio, equipo.estadio) && Objects.equals(anhoFundacion, equipo.anhoFundacion) && Objects.equals(contratos, equipo.contratos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, prsidente, estadio, anhoFundacion, numSocios, contratos);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", prsidente='" + prsidente + '\'' +
                ", estadio='" + estadio + '\'' +
                ", anhoFundacion=" + anhoFundacion +
                ", numSocios=" + numSocios +
                ", contratos=" + contratos +
                '}';
    }
}
