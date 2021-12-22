package co.edu.utp.isc.gia.proyectoCrud.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private Long cedulaPaciente;
    private String nombre;
    private String apellido;
    private String estado;
    private String telefono;
    private String dirección;
    private Date fechaNacimiento;
    private String sexo;
    private String eps;
    private String estadoCivil;
}
