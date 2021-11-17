package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.Vehicle;
import com.hiro11.fleeapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    //Get All Vehicles
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    //Get Vehicle By Id
    public Optional<Vehicle> findById(int id) {
        return vehicleRepository.findById(id);
    }

    //Delete Vehicle
    public void delete(int id) {
        vehicleRepository.deleteById(id);
    }

    //Update Vehicle
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
