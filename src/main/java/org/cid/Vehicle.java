package org.cid;

import lombok.Getter;
import org.cid.enums.VehicleType;

@Getter
public abstract class Vehicle {

    private String registrationNumber;
    private VehicleType vehicleType;
    private String color;

    public Vehicle(String registrationNumber, VehicleType vehicleType, String color){
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }
}
