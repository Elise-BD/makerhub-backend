package technobel.formation.pip_backend.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technobel.formation.pip_backend.dal.entities.Personality;
@Repository
public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
}
