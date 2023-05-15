package com.geekster.MappingPractice.Service;

import com.geekster.MappingPractice.Model.Laptop;
import com.geekster.MappingPractice.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Optional<Laptop> getLaptopById(String id) {
        return laptopRepository.findById(id);
    }

    public void deleteLaptop(String id) {
        laptopRepository.deleteById(id);
    }

    public Laptop updateLaptop(String id, Laptop laptop) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()) {
            Laptop existingLaptop = optionalLaptop.get();
            existingLaptop.setName(laptop.getName());
            existingLaptop.setBrand(laptop.getBrand());
            existingLaptop.setPrice(laptop.getPrice());
            existingLaptop.setStudent(laptop.getStudent());
            return laptopRepository.save(existingLaptop);
        } else {
            return null;
        }
    }
}
