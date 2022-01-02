package co.edu.utp.isc.gia.proyectoCrud.Repository;

import co.edu.utp.isc.gia.proyectoCrud.Entities.PersonalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalRepository extends CrudRepository<PersonalEntity,Long> {

    List<PersonalEntity> findByTipo(String tipo);
}
