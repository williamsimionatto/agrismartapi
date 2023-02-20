package agrismart.com.agrismart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agrismart.com.agrismart.domain.Pasture;
import agrismart.com.agrismart.dto.pasture.AddPastureDTO;
import agrismart.com.agrismart.service.FarmService;
import agrismart.com.agrismart.service.PastureService;
import agrismart.com.agrismart.service.exceptions.ObjectnotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/pasture")
public class PastureController {
  @Autowired
  private PastureService pastureService;

  @Autowired
  private FarmService farmService;

  @PostMapping
  public ResponseEntity<Pasture> createPasture(@RequestBody AddPastureDTO data) {
      if (!farmService.exists(data.getFarmId())) {
        throw new ObjectnotFoundException("Farm: " + data.getFarmId() + " not found");
      }
  
      Pasture pasture = pastureService.save(data);
      return ResponseEntity.ok(pasture);
  }

  @GetMapping
  public ResponseEntity<List<Pasture>> getAllPastures() {
    List<Pasture> pastures = pastureService.allPastures();
    return ResponseEntity.ok(pastures);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pasture> getPasture(@PathVariable Long id) {
    Pasture pasture = pastureService.getPasture(id);
    return ResponseEntity.ok(pasture); 
  }
}
