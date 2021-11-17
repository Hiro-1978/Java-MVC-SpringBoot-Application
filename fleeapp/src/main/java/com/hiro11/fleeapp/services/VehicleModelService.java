package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.VehicleModel;
import com.hiro11.fleeapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Get All VehicleModel
    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    //Get VehicleModel By Id
    public Optional<VehicleModel> findById(int id) {
        return vehicleModelRepository.findById(id);
    }

    //Delete VehicleModel
    public void delete(int id) {
        vehicleModelRepository.deleteById(id);
    }

    //Update VehicleModel
    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }
}
