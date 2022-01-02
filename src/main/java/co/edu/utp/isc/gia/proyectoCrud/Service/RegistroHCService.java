package co.edu.utp.isc.gia.proyectoCrud.Service;

import co.edu.utp.isc.gia.proyectoCrud.DTO.RegistroHCDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;

import java.util.Date;
import java.util.List;

public interface RegistroHCService {
    RegistroHCDTO crearRegistro(RegistroHCDTO registroHCDTO) throws FaltaInfoException;

    List<RegistroHCDTO> consultarPorFecha(Date fecha) throws NoExisteException;

    List<RegistroHCDTO> consultarPorPaciente(Long cedulaPaciente) throws NoExisteException;

    List<RegistroHCDTO> consultarPorPersonal(Long cedulaPersonal) throws NoExisteException;

    RegistroHCDTO actualizarRegistro(RegistroHCDTO registroHCDTO) throws NoExisteException, FaltaInfoException;

    void borrarRegistro(Long codRegistro) throws NoExisteException;

    void borrarHistorial(Long cedulaPaciente) throws NoExisteException;
}
