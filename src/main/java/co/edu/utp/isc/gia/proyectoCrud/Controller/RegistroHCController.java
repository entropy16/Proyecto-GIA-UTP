package co.edu.utp.isc.gia.proyectoCrud.Controller;

import co.edu.utp.isc.gia.proyectoCrud.DTO.RegistroHCDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;
import co.edu.utp.isc.gia.proyectoCrud.Service.RegistroHCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("historialClinico")
public class RegistroHCController {

    @Autowired
    public RegistroHCService registroHCService;

    @PostMapping("crearRegistro")
    public RegistroHCDTO crearRegistro(@RequestBody RegistroHCDTO registroHCDTO) throws FaltaInfoException {
        return registroHCService.crearRegistro(registroHCDTO);
    }

    @GetMapping("consultarFecha")
    public List<RegistroHCDTO> consultarPorFecha(@RequestParam Date fecha) throws NoExisteException {
        return registroHCService.consultarPorFecha(fecha);
    }

    @GetMapping("consultarPaciente")
    public List<RegistroHCDTO> conssultarPorPaciente(@RequestParam Long cedulaPaciente) throws NoExisteException {
        return registroHCService.consultarPorPaciente(cedulaPaciente);
    }

    @GetMapping("consultarPersonal")
    public List<RegistroHCDTO> consultarPorPersonal(@RequestParam Long cedulaPersonal) throws NoExisteException {
        return registroHCService.consultarPorPersonal(cedulaPersonal);
    }

    @PutMapping("actualizarRegistro")
    public RegistroHCDTO actualizarRegistro(@RequestBody RegistroHCDTO registroHCDTO)
            throws NoExisteException, FaltaInfoException {
        return registroHCService.actualizarRegistro(registroHCDTO);
    }

    @DeleteMapping("borrarRegistro")
    public void borrarRegistro(@RequestParam Long codRegistro) throws NoExisteException {
        registroHCService.borrarRegistro(codRegistro);
    }

    @DeleteMapping("borrarHistorial")
    public void borrarHistorial(@RequestParam Long cedulaPaciente) throws NoExisteException {
        registroHCService.borrarHistorial(cedulaPaciente);
    }
}
