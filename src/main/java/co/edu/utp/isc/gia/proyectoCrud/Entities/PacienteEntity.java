package co.edu.utp.isc.gia.proyectoCrud.Entities;

import co.edu.utp.isc.gia.proyectoCrud.DTO.RegistroHCDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PACIENTES")
public class PacienteEntity {

    @Id
    private Long cedulaPaciente;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<RegistroHCEntity> historial;

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

    public boolean añadirRegistro(RegistroHCEntity registroHCEntity){
        if(historial == null) {
            historial = new ArrayList<>();
        }
        return this.historial.add(registroHCEntity);
    }
}
