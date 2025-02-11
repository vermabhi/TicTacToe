package org.cid;

import org.cid.enums.VehicleType;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private String parkingLotId;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(String parkingLotId, int totalParkingFloors, int totalParkingSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.parkingFloors = new ArrayList<>();
        addParkingFloors(totalParkingFloors, totalParkingSlotsPerFloor);
    }

    private void addParkingFloors(int totalParkingFloors, int totalParkingSlotsPerFloor){
        for (int floor = 0; floor < totalParkingFloors; floor++) {
            parkingFloors.add(new ParkingFloor(floor+1, totalParkingSlotsPerFloor));
        }
    }

    public void getFreeSlotsCount(VehicleType vehicleType){
        parkingFloors.forEach( floor -> {
            floor.getFreeCount(vehicleType);
        });
    }

    public void getFreeSlots(VehicleType vehicleType) {
        parkingFloors.forEach( floor -> {
            floor.getFreeSlots(vehicleType);
        });
    }

    public void getOccupiedSlots(VehicleType vehicleType) {
        parkingFloors.forEach( floor -> {
            floor.getOccupiedSlots(vehicleType);
        });
    }

    public void parkVehicle(VehicleType vehicleType, String vehicleRegistrationNo, String color) {
        String parkingSlotId = null;
        for (int floor = 0; floor < parkingFloors.size(); floor++) {
            parkingSlotId = parkingFloors.get(floor).getAvailableSlot(vehicleType, vehicleRegistrationNo, color);
            if (Objects.nonNull(parkingSlotId)){
                break;
            }
        }
        if (Objects.isNull(parkingSlotId)){
            System.out.println("Parking Lot Full");
            return;
        }
        System.out.println("Parked vehicle. Ticket ID: "+String.join("_", parkingLotId, parkingSlotId));
    }

    public void unparkVehcile(String ticketId){
        List<String> ticketPart = Arrays.stream(ticketId.split("_")).toList();
        if(ticketPart.size() != 3){
            System.out.println("Invalid Ticket");
            return;
        }
        parkingFloors.get(Integer.parseInt(ticketPart.get(1))-1).unparkVehicle(Integer.parseInt(ticketPart.get(2)));
    }

}
