package agrismart.com.agrismart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agrismart.com.agrismart.domain.Farm;
import agrismart.com.agrismart.dto.AddFarmDTO;
import agrismart.com.agrismart.repository.FarmRepository;
import agrismart.com.agrismart.service.exceptions.ObjectnotFoundException;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> allFarms() {
        return farmRepository.findAll();
    }

    public Farm getFarm(Long id) {
        Optional<Farm> farm = farmRepository.findById(id);

        return farm.orElseThrow(() -> new ObjectnotFoundException("Farm not found"));
    }

    public Farm save(AddFarmDTO farm) {
        Farm newFarm = new Farm(farm);
        return farmRepository.save(newFarm);
    }

    public Farm update(Long id, AddFarmDTO farm) {
        Farm newFarm = getFarm(id);
        newFarm.setName(farm.getName());
        newFarm.setAddress(farm.getAddress());
        return farmRepository.save(newFarm);
    }

    public void delete(Long id) {
        Farm farm = getFarm(id);

        if (farm == null) {
            throw new ObjectnotFoundException("Farm not found");
        }
 
        farmRepository.deleteById(id);
    }
}
