package co.edu.utp.isc.gia.proyectoCrud.Repository;

import co.edu.utp.isc.gia.proyectoCrud.DTO.PacienteDTO;
import co.edu.utp.isc.gia.proyectoCrud.Entities.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {

}
