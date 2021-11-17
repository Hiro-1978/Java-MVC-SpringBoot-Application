package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.VehicleMovement;
import com.hiro11.fleeapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    //Get All VehicleMovements
    public List<VehicleMovement> getVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    //Get VehicleMovement By Id
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementRepository.findById(id);
    }

    //Delete VehicleMovement
    public void delete(int id) {
        vehicleMovementRepository.deleteById(id);
    }

    //Update VehicleMovement
    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

}

