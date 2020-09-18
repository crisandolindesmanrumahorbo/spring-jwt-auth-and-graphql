package com.example.demo;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

//    @PostMapping("/create")
    public Vehicle createVehicle(VehicleWrapper vehicle) {
        return this.vehicleService.createVehicle(vehicle);
    }
}
