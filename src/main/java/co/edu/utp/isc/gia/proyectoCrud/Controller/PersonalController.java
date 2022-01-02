package co.edu.utp.isc.gia.proyectoCrud.Controller;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PersonalDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;
import co.edu.utp.isc.gia.proyectoCrud.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personal")
public class PersonalController {

    @Autowired
    public PersonalService personalService;

    @PutMapping("crearPersonal")
    public PersonalDTO crearPersonal(@RequestBody PersonalDTO personalDTO) throws FaltaInfoException {
        return personalService.crearPersonal(personalDTO);
    }

    @GetMapping("consultarPersonal")
    public PersonalDTO consultarPersonal(@RequestParam Long cedulaPersonal) throws NoExisteException {
        return personalService.consultarPersonal(cedulaPersonal);
    }

    @GetMapping("consultarTipo")
    public List<PersonalDTO> consultarPorTipo(@RequestParam String tipo) throws NoExisteException {
        return personalService.consultarPorTipo(tipo);
    }

    @PutMapping("actualizarPersonal")
    public PersonalDTO actualizarPersonal(@RequestBody PersonalDTO personalDTO)
            throws NoExisteException, FaltaInfoException{
        return personalService.actualizarPersonal(personalDTO);
    }

    @DeleteMapping("borrarPersonal")
    public PersonalDTO borrarPersonal(@RequestParam Long cedulaPesonal) throws NoExisteException {
        return personalService.borrarPersonal(cedulaPesonal);
    }
}
