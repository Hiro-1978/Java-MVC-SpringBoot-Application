package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.Supplier;
import com.hiro11.fleeapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    //Get All Suppliers
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    //Get Supplier By Id
    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    //Delete Supplier
    public void delete(int id) {
        supplierRepository.deleteById(id);
    }

    //Update Supplier
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
