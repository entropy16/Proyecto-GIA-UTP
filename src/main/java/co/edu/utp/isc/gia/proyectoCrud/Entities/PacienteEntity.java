package co.edu.utp.isc.gia.proyectoCrud.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PACIENTES")
public class PacienteEntity {

    @Id
    private Long cedulaPaciente;


    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String nombre;
    private String apellido;
    private String estado;
    private String telefono;
    private String direccion;
    private String sexo;
    private String eps;
    private String estadoCivil;

}
