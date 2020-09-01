package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }

//    @Transactional
    public Vehicle createVehicle(VehicleWrapper inputVehicle) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(inputVehicle.getType());
        vehicle.setModelCode(inputVehicle.getModelCode());
        vehicle.setBrandName(inputVehicle.getBrandName());
//        vehicle.setLaunchDate(LocalDate.parse(inputVehicle.getLaunchDate()));
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
//        List<Vehicle> vehicles = new ArrayList();
//        Vehicle spv = Vehicle.builder()
//                .type("car")
//                .modelCode("11q")
//                .build();
//        vehicles.add(spv);
//        return vehicles;
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(Integer id) {
        return this.vehicleRepository.findById(id);
    }
}
