package org.cid;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
public class ParkingSlot {

    private final int parkingSlotId;
    private boolean isSlotAvailable;
    private String parkedVehicleNo;
    private String vehicleColor;


    public ParkingSlot(int parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
        this.isSlotAvailable = true;
        this.parkedVehicleNo = null;
        this.vehicleColor = null;
    }

    public boolean isSlotAvailable() {
        return isSlotAvailable;
    }

    public void occupySlot(String vehicleRegistrationNo, String color) {
        this.parkedVehicleNo = vehicleRegistrationNo;
        this.vehicleColor = color;
        this.isSlotAvailable = false;
    }

    public void vacateSlot(){
        if(isSlotAvailable){
            System.out.println("Invalid Ticket");
            return;
        }
        this.parkedVehicleNo = null;
        this.vehicleColor = null;
        this.isSlotAvailable = true;
        System.out.println("Unparked vehicle with Registration Number: "+parkedVehicleNo+" and Color: "+vehicleColor);
    }
}
