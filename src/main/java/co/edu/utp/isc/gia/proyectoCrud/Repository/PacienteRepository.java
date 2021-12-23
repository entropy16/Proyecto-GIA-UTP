package co.edu.utp.isc.gia.proyectoCrud.Repository;

import co.edu.utp.isc.gia.proyectoCrud.Entities.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {

    List<PacienteEntity> findAllByEstado(String estado);
}
