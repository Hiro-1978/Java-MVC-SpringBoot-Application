package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.VehicleMaintenance;
import com.hiro11.fleeapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    //Get All VehicleMaintenances
    public List<VehicleMaintenance> getVehicleMaintenances(){
        return vehicleMaintenanceRepository.findAll();
    }

    //Get VehicleMaintenance By Id
    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceRepository.findById(id);
    }

    //Delete VehicleMaintenance
    public void delete(int id) {
        vehicleMaintenanceRepository.deleteById(id);
    }

    //Update VehicleMaintenance
    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }
}

