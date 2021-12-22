package co.edu.utp.isc.gia.proyectoCrud.Service;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;

public interface PacienteService {

    PacienteDTO crearPaciente(PacienteDTO pacienteDTO) throws FaltaInfoException;
}

