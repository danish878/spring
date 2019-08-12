package com.danny.crudwebdemo.controller;

import com.danny.crudwebdemo.entity.Location;
import com.danny.crudwebdemo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable("id") int id) {
        return locationRepository.findById(id).get();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable("id") int id) {
        locationRepository.deleteById(id);
    }
}
