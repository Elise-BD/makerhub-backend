package technobel.formation.pip_backend.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technobel.formation.pip_backend.dal.entities.Text;
@Repository
public interface TextRepository extends JpaRepository<Text, String> {
}
