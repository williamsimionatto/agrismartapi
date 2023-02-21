package agrismart.com.agrismart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agrismart.com.agrismart.domain.Pasture;

@Repository
public interface PastureRepository extends JpaRepository<Pasture, Long> {
  public List<Pasture> getPasturesByFarmId(Long farmId);
}
