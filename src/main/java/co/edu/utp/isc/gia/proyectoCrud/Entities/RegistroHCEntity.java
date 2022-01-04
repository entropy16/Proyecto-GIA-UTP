package co.edu.utp.isc.gia.proyectoCrud.Entities;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedPac", foreignKey = @ForeignKey(name = "cedPac"))
    public PacienteEntity paciente;

    private Long cedulaPaciente;
    private String descripcion;
    private String tipoProcedimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedPer", foreignKey = @ForeignKey(name = "cedPer"))
    public PersonalEntity personal;

    private Long cedulaPersonal;
    private String estadoPaciente;
}
