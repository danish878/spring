package com.danny.crudwebdemo.service;

import com.danny.crudwebdemo.entity.Location;

import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(int id);

    Location getLocationById(int id);

    List<Location> getAllLocations();
}
