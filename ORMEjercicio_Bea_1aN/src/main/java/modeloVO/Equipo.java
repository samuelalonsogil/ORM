package modeloVO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @Column(name = "eqNombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "eqPresidente", nullable = false, length = 50)
    private String presidente;
    @Column(name = "eqEstadio", nullable = false, length = 50)
    private String estadio;
    @Column(name = "eqAnhoFundacion", nullable = false)
    private int anhoFundacion;
    @Column(name = "eqNumSocios", nullable = false)
    private int numSocios;

    @OneToMany(mappedBy = "equi")
    private List<Contrato> contratos;

    public Equipo() {
    }

    public Equipo(String nombre, String presidente, String estadio, int anhoFundacion, int numSocios, List<Contrato> contratos) {
        this.nombre = nombre;
        this.presidente = presidente;
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

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getAnhoFundacion() {
        return anhoFundacion;
    }

    public void setAnhoFundacion(int anhoFundacion) {
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
        return anhoFundacion == equipo.anhoFundacion && numSocios == equipo.numSocios && nombre.equals(equipo.nombre) && presidente.equals(equipo.presidente) && estadio.equals(equipo.estadio) && contratos.equals(equipo.contratos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, presidente, estadio, anhoFundacion, numSocios, contratos);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", presidente='" + presidente + '\'' +
                ", estadio='" + estadio + '\'' +
                ", anhoFundacion=" + anhoFundacion +
                ", numSocios=" + numSocios +
                '}';
    }
}