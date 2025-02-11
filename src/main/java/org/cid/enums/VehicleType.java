package org.cid.enums;

import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VehicleType {

    CAR("car"),
    BIKE("bike"),
    TRUCK("truck");

    private final String displayName;

    VehicleType(String displayName){
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public static VehicleType getVehicleTypeEnum(String vehicleType) {
        for(VehicleType vehicleType1: values()) {
            if (vehicleType1.displayName.equalsIgnoreCase(vehicleType)){
                return vehicleType1;
            }
        }
        return null;
    }
}
