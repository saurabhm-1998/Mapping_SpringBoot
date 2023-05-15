package com.geekster.MappingPractice.Controller;

import com.geekster.MappingPractice.Model.Laptop;
import com.geekster.MappingPractice.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable String id) {
        Optional<Laptop> optionalLaptop = laptopService.getLaptopById(id);
        if (optionalLaptop.isPresent()) {
            return ResponseEntity.ok(optionalLaptop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.createLaptop(laptop);
        return ResponseEntity.created(URI.create("/api/laptops/" + createdLaptop.getID())).body(createdLaptop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable String id, @RequestBody Laptop laptop) {
        Laptop updatedLaptop = laptopService.updateLaptop(id, laptop);
        if (updatedLaptop != null) {
            return ResponseEntity.ok(updatedLaptop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable String id) {
        laptopService.deleteLaptop(id);
        return ResponseEntity.noContent().build();
    }
}
