package org.cid.enums;

import lombok.Getter;

public enum SpotType {
    CARSPOT("car spot"),
    BIKESPOT("Bike spot"),
    TRUCKSPOT("Truck spot");

    @Getter
    private String displayName;

    SpotType(String displayName){
        this.displayName = displayName;
    }
}
