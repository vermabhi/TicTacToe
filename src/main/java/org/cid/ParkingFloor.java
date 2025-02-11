package org.cid;

import lombok.Getter;
import org.cid.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class ParkingFloor {

    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber, int totalParkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = new ArrayList<>();
        addParkingSlots(totalParkingSlots);
    }

    private void addParkingSlots(int totalParkingSlots){
        for (int i = 0; i < totalParkingSlots; i++) {
            parkingSlots.add(new ParkingSlot(i+1));
        }
    }

    public void getFreeCount(VehicleType vehicleType){
        int freeSlots = 0;
        switch (vehicleType) {
            case CAR -> {
                for (int slot = 3; slot < parkingSlots.size(); slot++) {
                    if(parkingSlots.get(slot).isSlotAvailable()) {
                        freeSlots++;
                    }
                }
            }
            case BIKE -> {
                freeSlots += parkingSlots.get(1).isSlotAvailable() ? 1:0;
                freeSlots += parkingSlots.get(2).isSlotAvailable() ? 1:0;
            }
            case TRUCK -> {
                freeSlots += parkingSlots.get(0).isSlotAvailable() ? 1:0;
            }
            default -> {
                System.out.println("Invalid vehicle type for getting free slots count");
                return;
            }
        }
        System.out.println("No. of free slots for " + vehicleType.getDisplayName() + " on Floor " + floorNumber +": "+ freeSlots);
    }

    public void getFreeSlots(VehicleType vehicleType){
        List<Integer> freeSlots = new ArrayList<>();
        switch (vehicleType) {
            case CAR -> {
                for (int slot = 3; slot < parkingSlots.size(); slot++) {
                    if(parkingSlots.get(slot).isSlotAvailable()) {
                        freeSlots.add(slot);
                    }
                }
            }
            case BIKE -> {
                if(parkingSlots.get(1).isSlotAvailable()){
                    freeSlots.add(1);
                }
                if(parkingSlots.get(2).isSlotAvailable()){
                    freeSlots.add(2);
                }
            }
            case TRUCK -> {
                if (parkingSlots.get(0).isSlotAvailable()){
                    freeSlots.add(0);
                }
            }
            default -> {
                System.out.println("Invalid vehicle type for getting free slots");
                return;
            }
        }
        System.out.println("No. of free slots for "+vehicleType.getDisplayName()+" on Floor "+floorNumber+" : "+ freeSlots.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    public void getOccupiedSlots(VehicleType vehicleType) {
        List<Integer> occupiedSlots = new ArrayList<>();
        switch (vehicleType) {
            case CAR -> {
                for (int slot = 3; slot < parkingSlots.size(); slot++) {
                    if(!parkingSlots.get(slot).isSlotAvailable()) {
                        occupiedSlots.add(slot);
                    }
                }
            }
            case BIKE -> {
                if(!parkingSlots.get(1).isSlotAvailable()){
                    occupiedSlots.add(1);
                }
                if(!parkingSlots.get(2).isSlotAvailable()){
                    occupiedSlots.add(2);
                }
            }
            case TRUCK -> {
                if (!parkingSlots.get(0).isSlotAvailable()){
                    occupiedSlots.add(0);
                }
            }
            default -> {
                System.out.println("Invalid vehicle type for getting occupied slots");
                return;
            }
        }
        System.out.println("No. of free slots for "+vehicleType.getDisplayName()+" on Floor "+floorNumber+" : "+ occupiedSlots.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    public String getAvailableSlot(VehicleType vehicleType, String vehicleRegistrationNo, String color) {
        switch (vehicleType) {
            case BIKE -> {
                if(parkingSlots.get(1).isSlotAvailable()){
                    parkingSlots.get(1).occupySlot(vehicleRegistrationNo, color);
                    return String.join("_", String.valueOf(floorNumber), String.valueOf(1));
                }
                if(parkingSlots.get(2).isSlotAvailable()) {
                    parkingSlots.get(2).occupySlot(vehicleRegistrationNo, color);
                    return String.join("_", String.valueOf(floorNumber), String.valueOf(2));
                }
                return null;
            }
            case TRUCK -> {
                if(parkingSlots.get(0).isSlotAvailable()){
                    parkingSlots.get(0).occupySlot(vehicleRegistrationNo, color);
                    return String.join("_", String.valueOf(floorNumber), String.valueOf(0));
                }
                return null;
            }
            case CAR -> {
                for(int slot = 3; slot< parkingSlots.size() ;slot++){
                    if(parkingSlots.get(slot).isSlotAvailable()){
                        parkingSlots.get(slot).occupySlot(vehicleRegistrationNo, color);
                        return String.join("_", String.valueOf(floorNumber), String.valueOf(slot));
                    }
                }
                return null;
            }
            default -> {
                System.out.println("Invalid Vehicle Type for parking");
                return null;
            }
        }
    }

    public void unparkVehicle(int slotNumber) {
        System.out.println("");
        parkingSlots.get(slotNumber).vacateSlot();
    }
}
