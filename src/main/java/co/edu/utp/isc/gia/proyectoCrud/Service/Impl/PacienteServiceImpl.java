package co.edu.utp.isc.gia.proyectoCrud.Service.Impl;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Entities.PacienteEntity;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;
import co.edu.utp.isc.gia.proyectoCrud.Repository.PacienteRepository;
import co.edu.utp.isc.gia.proyectoCrud.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) throws FaltaInfoException {
        if(!pacienteDTO.equals(null) && pacienteDTO != null){
            PacienteEntity pacienteEntity = modelMapper.map(pacienteDTO, PacienteEntity.class);

            return modelMapper.map(this.pacienteRepository.save(pacienteEntity), PacienteDTO.class);
        } else {
            throw new FaltaInfoException("Falta información para la creación del paciente");
        }
    }

    @Override
    public PacienteDTO consultarPaciente(Long cedulaPaciente) throws NoExisteException {
        if(pacienteRepository.existsById(cedulaPaciente)){
            Optional<PacienteEntity> pacienteEntity = this.pacienteRepository.findById(cedulaPaciente);
            PacienteDTO pacienteDTO = modelMapper.map(pacienteEntity.get(), PacienteDTO.class);

            return pacienteDTO;
        } else {
            throw new NoExisteException("No existe un paciente registrado con esa cédula");
        }
    }

    @Override
    public PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) throws NoExisteException,FaltaInfoException{
        if(!pacienteDTO.equals(null) && pacienteDTO != null) {
            if (pacienteRepository.existsById(pacienteDTO.getCedulaPaciente())) {
                PacienteEntity pacienteEntity = this.pacienteRepository.save(modelMapper.map(pacienteDTO,
                                                                              PacienteEntity.class));

                PacienteDTO pacienteDTOReturn = modelMapper.map(pacienteEntity, PacienteDTO.class);
                return pacienteDTOReturn;
            } else {
                throw new NoExisteException("No existe un paciente registrado con esa cédula");
            }
        } else {
            throw new FaltaInfoException("Falta información para la creación del paciente");
        }
    }

    @Override
    public PacienteDTO borrarPaciente(Long cedulaPaciente) throws NoExisteException {
        if(pacienteRepository.existsById(cedulaPaciente)){
            PacienteDTO pacienteDTO = modelMapper.map(pacienteRepository.findById(cedulaPaciente).get(), PacienteDTO.class);
            pacienteRepository.deleteById(cedulaPaciente);
            return pacienteDTO;
        } else {
            throw new NoExisteException("No existe un paciente registrado con esa cédula");
        }
    }

    @Override
    public List<PacienteDTO> consultarEstado(String estado) throws NoExisteException {
        List<PacienteEntity> pacienteEstado = pacienteRepository.findAllByEstado(estado);

        List<PacienteDTO> pacienteDTOEstado = new ArrayList<>();

        if (pacienteEstado != null){
            pacienteEstado.forEach(pacienteEntity ->
                        pacienteDTOEstado.add(modelMapper.map(pacienteEntity, PacienteDTO.class))
                    );
            return pacienteDTOEstado;
        } else {
            throw new NoExisteException("No existen pacientes en este estado");
        }
    }
}
