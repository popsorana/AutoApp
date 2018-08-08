package testproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testproject.demo.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
