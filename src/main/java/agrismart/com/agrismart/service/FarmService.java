package agrismart.com.agrismart.service;

import agrismart.com.agrismart.domain.Farm;
import agrismart.com.agrismart.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> allFarms() {
        return farmRepository.findAll();
    }
}
