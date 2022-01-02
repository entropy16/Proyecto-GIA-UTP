package co.edu.utp.isc.gia.proyectoCrud.Entities;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGISTROSHC")
public class RegistroHCEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codRegistro;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="CEDULA_PACIENTE")
    private PacienteDTO paciente;

    private Long cedulaPaciente;

    private String procedimiento;
    private String descripción;
    private String tipoProcedimiento;
    private Long cedulaPersonal;
    private String estadoPaciente;
}
