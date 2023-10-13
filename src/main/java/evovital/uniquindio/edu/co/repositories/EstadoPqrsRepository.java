package evovital.uniquindio.edu.co.repositories;

import evovital.uniquindio.edu.co.domain.EstadoPqrs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoPqrsRepository extends JpaRepository<EstadoPqrs, Long> {

    EstadoPqrs findByEstado(String estado);

}
