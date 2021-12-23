package co.edu.utp.isc.gia.proyectoCrud.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDTO {

    private Long cedulaPersonal;
    private String tipo;
    private String nombre;
    private String apellido;
    private String departamento;
    private String telefono;
}
