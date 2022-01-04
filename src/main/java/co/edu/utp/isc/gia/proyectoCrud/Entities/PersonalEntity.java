package co.edu.utp.isc.gia.proyectoCrud.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAL")
public class PersonalEntity {

    @Id
    private Long cedulaPersonal;
    private String tipo;
    private String nombre;
    private String apellido;
    private String departamento;
    private String telefono;

}
