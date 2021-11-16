package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.Location;
import com.hiro11.fleeapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    //Get All Location
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    //Get Location By Id
    public Optional<Location> findById(int id) {
        return locationRepository.findById(id);
    }

    //Delete Location
    public void delete(int id) {

        locationRepository.deleteById(id);
    }

    //Update Location
    public void save(Location location) {

        locationRepository.save(location);
    }
}
