package co.edu.utp.isc.gia.proyectoCrud.Controller;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("crearPaciente")
    public PacienteDTO crearPaciente(@RequestBody PacienteDTO pacienteDTO) throws FaltaInfoException {
        return pacienteService.crearPaciente(pacienteDTO);
    }
}
