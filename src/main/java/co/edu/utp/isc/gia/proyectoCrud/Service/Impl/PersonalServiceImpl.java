package co.edu.utp.isc.gia.proyectoCrud.Service.Impl;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PersonalDTO;
import co.edu.utp.isc.gia.proyectoCrud.Entities.PersonalEntity;
import co.edu.utp.isc.gia.proyectoCrud.Exceptions.NoExisteException;
import co.edu.utp.isc.gia.proyectoCrud.Repository.PersonalRepository;
import co.edu.utp.isc.gia.proyectoCrud.Service.PersonalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    public PersonalRepository personalRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public PersonalDTO crearPersonal(PersonalDTO personalDTO) {

        PersonalEntity personalEntity = this.personalRepository.save(modelMapper.map(personalDTO,
                                                                                PersonalEntity.class));
        return modelMapper.map(personalEntity, PersonalDTO.class);
    }

    @Override
    public PersonalDTO consultarPersonal(Long cedulaPersonal) throws NoExisteException {
        if(personalRepository.existsById(cedulaPersonal)){
            Optional<PersonalEntity> personalEntity = personalRepository.findById(cedulaPersonal);

            return modelMapper.map(personalEntity.get(), PersonalDTO.class);
        } else {
            throw new NoExisteException("No existe personal registrado con esa cédula");
        }
    }

    @Override
    public List<PersonalDTO> consultarPorTipo(String tipo) throws NoExisteException {
        List<PersonalEntity> personalEntityList = personalRepository.findByTipo(tipo);

        List<PersonalDTO> personalDTOList = new ArrayList<>();

        if (personalEntityList != null){
            personalEntityList.forEach(personalEntity ->
                        personalDTOList.add(modelMapper.map(personalEntity, PersonalDTO.class))
                    );

            return personalDTOList;
        } else {
            throw new NoExisteException("No existe personal registrado como ese tipo de profesional de la Salud");
        }
    }

    @Override
    public PersonalDTO actualizarPersonal(PersonalDTO personalDTO) throws NoExisteException {
        if(personalRepository.existsById(personalDTO.getCedulaPersonal())){
            PersonalEntity personalEntity = personalRepository.save(modelMapper.map(personalDTO, PersonalEntity.class));

            return modelMapper.map(personalEntity, PersonalDTO.class);
        } else {
            throw new NoExisteException("No existe personal registrado con esa cédula");
        }
    }

    @Override
    public PersonalDTO borrarPersonal(Long cedulaPesonal) throws NoExisteException{
        if(personalRepository.existsById(cedulaPesonal)){
            PersonalDTO personalDTOReturn = modelMapper.map(personalRepository.findById(cedulaPesonal),
                                                            PersonalDTO.class);
            personalRepository.deleteById(cedulaPesonal);
            return personalDTOReturn;
        } else {
            throw new NoExisteException("No existe personal registrado con esta cédula");
        }
    }
}
