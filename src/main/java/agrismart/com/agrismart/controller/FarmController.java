package agrismart.com.agrismart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agrismart.com.agrismart.domain.Farm;
import agrismart.com.agrismart.dto.AddFarmDTO;
import agrismart.com.agrismart.service.FarmService;

@RestController
@RequestMapping("/api/farm")
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping
    public ResponseEntity<List<Farm>> allFarms() {
        List<Farm> farms = farmService.allFarms();
        return new ResponseEntity<List<Farm>>(farms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getMovie(@PathVariable Long id) {
        Farm farm = farmService.getFarm(id);
        return new ResponseEntity<Farm>(farm, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody AddFarmDTO data) {
        Farm farm = farmService.save(data);
        return new ResponseEntity<Farm>(farm, HttpStatus.CREATED);
    }
}
