package technobel.formation.pip_backend.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technobel.formation.pip_backend.dal.entities.Riasec;
@Repository
public interface RiasecRepository extends JpaRepository<Riasec, Integer> {
}
