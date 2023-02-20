package agrismart.com.agrismart.controller;

import agrismart.com.agrismart.domain.Farm;
import agrismart.com.agrismart.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
