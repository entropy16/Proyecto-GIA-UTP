package co.edu.utp.isc.gia.proyectoCrud.Repository;

import co.edu.utp.isc.gia.proyectoCrud.Entities.RegistroHCEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RegistroHCRepository extends CrudRepository<RegistroHCEntity, Long> {

    List<RegistroHCEntity> findByFechaRegistro(Date fechaRegistro);

    List<RegistroHCEntity> findByCedulaPaciente(Long cedulaPaciente);

    List<RegistroHCEntity> findByCedulaPersonal(Long cedulaPersonal);
}
