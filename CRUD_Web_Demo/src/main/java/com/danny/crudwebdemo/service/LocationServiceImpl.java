package com.danny.crudwebdemo.service;

import com.danny.crudwebdemo.entity.Location;
import com.danny.crudwebdemo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public void deleteLocation(int id) {
        repository.deleteById(id);
    }

    @Override
    public Location getLocationById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
