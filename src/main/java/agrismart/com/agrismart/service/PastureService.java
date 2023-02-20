package agrismart.com.agrismart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agrismart.com.agrismart.domain.Farm;
import agrismart.com.agrismart.domain.Pasture;
import agrismart.com.agrismart.dto.pasture.AddPastureDTO;
import agrismart.com.agrismart.dto.pasture.EditPastureDTO;
import agrismart.com.agrismart.repository.PastureRepository;
import agrismart.com.agrismart.service.exceptions.ObjectnotFoundException;

@Service
public class PastureService {
  @Autowired
  private PastureRepository pastureRepository;

  @Autowired
  private FarmService farmService;

  public Pasture save(AddPastureDTO data) {
    Farm farm = farmService.getFarm(data.getFarmId());
    Pasture pasture = new Pasture(data);
    pasture.setFarm(farm);
    return pastureRepository.save(pasture);
  }

  public List<Pasture> allPastures() {
    return pastureRepository.findAll();
  }

  public Pasture getPasture(Long id) {
    return pastureRepository.findById(id).orElseThrow(() -> new ObjectnotFoundException("Pasture not found"));
  }

  public Pasture edit(Long id, EditPastureDTO data) {
    Farm farm = farmService.getFarm(data.getFarmId());
    Pasture pasture = getPasture(id);
    pasture.setFarm(farm);
    pasture.setName(data.getName());
    pasture.setArea(data.getArea());
    return pastureRepository.save(pasture);
  }
}
