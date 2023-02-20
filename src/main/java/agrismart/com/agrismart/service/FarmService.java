package agrismart.com.agrismart.service;

import agrismart.com.agrismart.domain.Farm;
import agrismart.com.agrismart.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> allFarms() {
        return farmRepository.findAll();
    }

    public Optional<Farm> getFarm(Long id) {
        return farmRepository.findById(id);
    }
}
