package co.edu.utp.isc.gia.proyectoCrud.Service.Impl;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Entities.PacienteEntity;
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
    public PacienteRepository pacienteRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = modelMapper.map(pacienteDTO, PacienteEntity.class);

        return modelMapper.map(this.pacienteRepository.save(pacienteEntity), PacienteDTO.class);
    }

    @Override
    public PacienteDTO consultarPaciente(Long cedulaPaciente) throws NoExisteException {
        if(pacienteRepository.existsById(cedulaPaciente)){
            Optional<PacienteEntity> pacienteEntity = this.pacienteRepository.findById(cedulaPaciente);

            return modelMapper.map(pacienteEntity.get(), PacienteDTO.class);
        } else {
            throw new NoExisteException("No existe un paciente registrado con esa cédula");
        }
    }

    @Override
    public PacienteDTO actualizarPaciente(PacienteDTO pacienteDTO) throws NoExisteException{
        if (pacienteRepository.existsById(pacienteDTO.getCedulaPaciente())) {
            PacienteEntity pacienteEntity = this.pacienteRepository.save(modelMapper.map(pacienteDTO,
                        PacienteEntity.class));

            return modelMapper.map(pacienteEntity, PacienteDTO.class);
        } else {
            throw new NoExisteException("No existe un paciente registrado con esa cédula");
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
