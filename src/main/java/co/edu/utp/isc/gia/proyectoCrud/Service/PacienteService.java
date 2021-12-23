package co.edu.utp.isc.gia.proyectoCrud.Service;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;

import java.util.List;

public interface PacienteService {

    PacienteDTO crearPaciente(PacienteDTO pacienteDTO) throws FaltaInfoException;
    PacienteDTO consultarPaciente(Long cedulaPaciente) throws NoExisteException;
    PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) throws NoExisteException,FaltaInfoException;
    PacienteDTO borrarPaciente(Long cedulaPaciente) throws NoExisteException;
    List<PacienteDTO> consultarEstado(String estado) throws NoExisteException;
}

