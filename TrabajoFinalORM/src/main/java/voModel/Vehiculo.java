package voModel;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "Vehiculos")
public class Vehiculo {

    @Id
    @Column(name = "veMatricula")
    private String matricula;

    @Column(name = "veMarca", nullable = false)
    private String marca;

    @Column(name = "veGrupo", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Enum grupo;

    @Column(name = "vePlazas", nullable = false)
    private int plazas;

    @Column(name = "vePuertas", nullable = false)
    private int puertas;

    @Column(name = "veMaletero", nullable = false)
    private int maletero;

    @Column(name = "veEdad", nullable = false)
    private int edad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veIdOficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "vehiculo")
    private List<VehiculoCliente> vehiculoClientes;

    public enum Grupo{
        A , B ,C, D, E, F, G
    }

    public Vehiculo() {}

    public Vehiculo(String matricula, String marca, Enum grupo, int plazas, int puertas, int maletero, int edad, Oficina oficina, List<VehiculoCliente> vehiculoClientes) {
        this.matricula = matricula;
        this.marca = marca;
        this.grupo = grupo;
        this.plazas = plazas;
        this.puertas = puertas;
        this.maletero = maletero;
        this.edad = edad;
        this.oficina = oficina;
        this.vehiculoClientes = vehiculoClientes;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Enum getGrupo() {
        return grupo;
    }

    public void setGrupo(Enum grupo) {
        this.grupo = grupo;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getMaletero() {
        return maletero;
    }

    public void setMaletero(int maletero) {
        this.maletero = maletero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public List<VehiculoCliente> getVehiculoClientes() {
        return vehiculoClientes;
    }

    public void setVehiculoClientes(List<VehiculoCliente> vehiculoClientes) {
        this.vehiculoClientes = vehiculoClientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return plazas == vehiculo.plazas && puertas == vehiculo.puertas && maletero == vehiculo.maletero && edad == vehiculo.edad && Objects.equals(matricula, vehiculo.matricula) && Objects.equals(marca, vehiculo.marca) && Objects.equals(grupo, vehiculo.grupo) && Objects.equals(oficina, vehiculo.oficina) && Objects.equals(vehiculoClientes, vehiculo.vehiculoClientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, marca, grupo, plazas, puertas, maletero, edad, oficina, vehiculoClientes);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", grupo=" + grupo +
                ", plazas=" + plazas +
                ", puertas=" + puertas +
                ", maletero=" + maletero +
                ", edad=" + edad +
                ", oficina=" + oficina +
                ", vehiculoClientes=" + vehiculoClientes +
                '}';
    }
}
