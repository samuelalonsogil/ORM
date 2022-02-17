package voModel;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "VehiculoCliente")
public class Cliente {

    @Id
    @Column(name = "clDni")
    private String dni;

    @Column(name = "clNombre")
    private String nombre;



    @OneToMany(mappedBy = cliente)
    private List<VehiculoCliente> vehiculoClientes;
}
