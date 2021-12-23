package co.edu.utp.isc.gia.proyectoCrud.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PACIENTES")
public class PacienteEntity {

    @Id
    private Long cedulaPaciente;
    private String nombre;
    private String apellido;
    private String estado;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private String sexo;
    private String eps;
    private String estadoCivil;
}
