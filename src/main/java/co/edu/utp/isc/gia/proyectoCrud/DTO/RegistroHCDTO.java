package co.edu.utp.isc.gia.proyectoCrud.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroHCDTO {

    private Long codRegistro;
    private Date fechaRegistro;
    private Long cedulaPaciente;
    private String procedimiento;
    private String descripción;
    private String tipoProcedimiento;
    private Long cedulaPersonal;
    private String estadoPaciente;
}
