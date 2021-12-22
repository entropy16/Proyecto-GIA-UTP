package co.edu.utp.isc.gia.proyectoCrud.Service.Impl;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Entities.PacienteEntity;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.FaltaInfoException;
import co.edu.utp.isc.gia.proyectoCrud.Repository.PacienteRepository;
import co.edu.utp.isc.gia.proyectoCrud.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

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
            return null;
        }
    }
}
