package co.edu.utp.isc.gia.proyectoCrud.Service.Impl;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.DTO.RegistroHCDTO;
import co.edu.utp.isc.gia.proyectoCrud.Entities.RegistroHCEntity;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;
import co.edu.utp.isc.gia.proyectoCrud.Repository.PacienteRepository;
import co.edu.utp.isc.gia.proyectoCrud.Repository.RegistroHCRepository;
import co.edu.utp.isc.gia.proyectoCrud.Service.PacienteService;
import co.edu.utp.isc.gia.proyectoCrud.Service.RegistroHCService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistroHCServiceImpl implements RegistroHCService {

    @Autowired
    public RegistroHCRepository registroHCRepository;

    @Autowired
    public PacienteService pacienteService;

    @Autowired
    public PacienteRepository pacienteRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public RegistroHCDTO crearRegistro(RegistroHCDTO registroHCDTO) throws NoExisteException {

        RegistroHCEntity registroHCEntity = registroHCRepository.save(modelMapper.map(registroHCDTO,
                                                                                    RegistroHCEntity.class));
        PacienteDTO pacienteDTO = modelMapper.map(pacienteRepository.findById(
                                            registroHCEntity.getCedulaPaciente()).get(), PacienteDTO.class);

        if(pacienteDTO.getEstado().equals( registroHCEntity.getEstadoPaciente() )) {
            pacienteDTO.setEstado(registroHCEntity.getEstadoPaciente());

            pacienteService.actualizarPaciente(pacienteDTO);
        }

        return modelMapper.map(registroHCEntity, RegistroHCDTO.class);
    }

    @Override
    public List<RegistroHCDTO> consultarPorFecha(Date fecha) throws NoExisteException {
        List<RegistroHCEntity> listaRegistroEnt = registroHCRepository.findByFechaRegistro(fecha);

        if( !listaRegistroEnt.isEmpty()){

            List<RegistroHCDTO> listaRegistroDTO = new ArrayList<>();
            listaRegistroEnt.forEach(registroEnt ->
                    listaRegistroDTO.add(modelMapper.map(registroEnt, RegistroHCDTO.class))
            );

            return listaRegistroDTO;
        } else {
            throw new NoExisteException("No hay registros guardados con esta fecha");
        }
    }

    @Override
    public List<RegistroHCDTO> consultarPorPaciente(Long cedulaPaciente) throws NoExisteException {
        List<RegistroHCEntity> listaRegistroEnt = registroHCRepository.findByCedulaPaciente(cedulaPaciente);

        if( !listaRegistroEnt.isEmpty()){

            List<RegistroHCDTO> listaRegistroDTO = new ArrayList<>();
            listaRegistroEnt.forEach(registroEnt ->
                    listaRegistroDTO.add(modelMapper.map(registroEnt, RegistroHCDTO.class))
            );

            return listaRegistroDTO;
        } else {
            throw new NoExisteException("No hay registros guardados con esta cédula de paciente");
        }
    }

    @Override
    public List<RegistroHCDTO> consultarPorPersonal(Long cedulaPersonal) throws NoExisteException {
        List<RegistroHCEntity> listaRegistroEnt = registroHCRepository.findByCedulaPersonal(cedulaPersonal);

        if( !listaRegistroEnt.isEmpty()){

            List<RegistroHCDTO> listaRegistroDTO = new ArrayList<>();
            listaRegistroEnt.forEach(registroEnt ->
                    listaRegistroDTO.add(modelMapper.map(registroEnt, RegistroHCDTO.class))
            );

            return listaRegistroDTO;
        } else {
            throw new NoExisteException("No hay registros guardados con esta cédula de personal");
        }
    }

    @Override
    public RegistroHCDTO actualizarRegistro(RegistroHCDTO registroHCDTO) throws NoExisteException {
        if(registroHCRepository.existsById(registroHCDTO.getCodRegistro())){
            RegistroHCEntity registroHCEntity = modelMapper.map(registroHCDTO, RegistroHCEntity.class);

            PacienteDTO pacienteDTO = modelMapper.map(pacienteRepository.findById(
                    registroHCEntity.getCedulaPaciente()).get(), PacienteDTO.class);

            if(pacienteDTO.getEstado().equals( registroHCEntity.getEstadoPaciente() )) {
                pacienteDTO.setEstado(registroHCEntity.getEstadoPaciente());

                pacienteService.actualizarPaciente(pacienteDTO);
            }

            return modelMapper.map(registroHCRepository.save(registroHCEntity), RegistroHCDTO.class);
        } else {
            throw new NoExisteException("No existe el registro que desea actualizar");
        }
    }

    @Override
    public void borrarRegistro(Long codRegistro) throws NoExisteException {
        if(registroHCRepository.existsById(codRegistro)){
            registroHCRepository.deleteById(codRegistro);
        } else {
            throw new NoExisteException("No existe un registro con ese código");
        }
    }

    @Override
    public void borrarHistorial(Long cedulaPaciente) throws NoExisteException {
        List<RegistroHCDTO> listaRegistroDTO = this.consultarPorPaciente(cedulaPaciente);

        if(!listaRegistroDTO.isEmpty()){
            listaRegistroDTO.forEach(registroHCDTO ->
                    registroHCRepository.deleteById(registroHCDTO.getCodRegistro())
            );
        } else {
            throw new NoExisteException("No hay un historial para este paciente");
        }
    }
}
