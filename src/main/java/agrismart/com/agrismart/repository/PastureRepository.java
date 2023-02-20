package agrismart.com.agrismart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agrismart.com.agrismart.domain.Pasture;

@Repository
public interface PastureRepository extends JpaRepository<Pasture, Long> {
  
}
