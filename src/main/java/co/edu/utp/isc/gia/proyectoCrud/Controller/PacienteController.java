package co.edu.utp.isc.gia.proyectoCrud.Controller;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;
import co.edu.utp.isc.gia.proyectoCrud.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    public PacienteService pacienteService;

    @PostMapping("crearPaciente")
    public PacienteDTO crearPaciente(@RequestBody PacienteDTO pacienteDTO) {

        return pacienteService.crearPaciente(pacienteDTO);
    }

    @GetMapping("consultarPaciente")
    public PacienteDTO consultarPaciente(@RequestParam Long cedulaPaciente) throws NoExisteException {

        return pacienteService.consultarPaciente(cedulaPaciente);
    }

    @GetMapping("consultarEstado")
    public List<PacienteDTO> consultarEstado(@RequestParam String estado) throws NoExisteException{

        return pacienteService.consultarEstado(estado);
    }

    @PutMapping("actualizarPaciente")
    public PacienteDTO actualizarPaciente(@RequestBody PacienteDTO pacienteDTO) throws NoExisteException {
        return pacienteService.actualizarPaciente(pacienteDTO);
    }

    @DeleteMapping("borrarPaciente")
    public PacienteDTO borrarPaciente(@RequestParam Long cedulaPaciente) throws NoExisteException {
        return pacienteService.borrarPaciente(cedulaPaciente);
    }
}
