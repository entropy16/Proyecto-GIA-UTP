package co.edu.utp.isc.gia.proyectoCrud.Service;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PersonalDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;

import java.util.List;

public interface PersonalService {
    PersonalDTO crearPersonal(PersonalDTO personalDTO);

    PersonalDTO consultarPersonal(Long cedulaPersonal) throws NoExisteException;

    List<PersonalDTO> consultarPorTipo(String tipo) throws NoExisteException;

    PersonalDTO actualizarPersonal(PersonalDTO personalDTO) throws NoExisteException;

    PersonalDTO borrarPersonal(Long cedulaPesonal) throws NoExisteException;
}
