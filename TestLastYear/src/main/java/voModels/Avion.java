package voModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "aviones")
public class Avion {

    @Id
    @Column(name = "avCodigo")
    int codigo;

    @Column(name = "avModelo", length = 30)
    String modelo;

    public Avion() {
    }

    public Avion(int codigo, String modelo) {
        this.codigo = codigo;
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return codigo == avion.codigo && Objects.equals(modelo, avion.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, modelo);
    }

    @Override
    public String toString() {
        return "Avion{" +
                "codigo=" + codigo +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
