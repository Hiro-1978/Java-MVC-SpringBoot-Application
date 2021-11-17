package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.VehicleHire;
import com.hiro11.fleeapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    //Get All VehicleHires
    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    //Get VehicleHire By Id
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireRepository.findById(id);
    }

    //Delete VehicleHire
    public void delete(int id) {
        vehicleHireRepository.deleteById(id);
    }

    //Update VehicleHire
    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }
}
