package org.cid;

import org.cid.enums.DisplayType;
import org.cid.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.cid.enums.DisplayType.*;

public class ParkingLotManager {

    private List<ParkingLot> parkingLots;

    private static ParkingLotManager parkingLotManager = null;

    private ParkingLotManager() {
        parkingLots = new ArrayList<>();
    }

    public static ParkingLotManager getParkingLotManager(){
        if(Objects.isNull(parkingLotManager)){
            parkingLotManager = new ParkingLotManager();
        }
        return parkingLotManager;
    }

    public void createParkingLot(String parkingLotId, int totalParkingFloors, int totalParkingSlotsPerFloor) {
        parkingLots.add(new ParkingLot(parkingLotId, totalParkingFloors, totalParkingSlotsPerFloor));
        System.out.println("Created parking lot with " + totalParkingFloors + "floors and " + totalParkingSlotsPerFloor + " slots per floor");
    }

    public void display(String displayType, String vehicleType){
        if (Objects.equals(FREE_COUNT.getDisplayType(), displayType)){
            parkingLots.get(0).getFreeSlotsCount(VehicleType.getVehicleTypeEnum(vehicleType));
        } else if (Objects.equals(FREE_SLOTS.getDisplayType(), displayType)){
            parkingLots.get(0).getFreeSlots(VehicleType.getVehicleTypeEnum(vehicleType));
        } else if (Objects.equals(OCCUPIED_SLOTS.getDisplayType(), displayType)){
            parkingLots.get(0).getOccupiedSlots(VehicleType.getVehicleTypeEnum(vehicleType));
        } else {
            System.out.println("Invalid display type");
        }
    }

    public void parkVehicle(String vehicleType, String registrationNumber, String color) {
        parkingLots.get(0).parkVehicle(VehicleType.getVehicleTypeEnum(vehicleType), registrationNumber, color);
    }

    public void unparkVehicle(String ticketId){
        System.out.println("");
        parkingLots.get(0).unparkVehcile(ticketId);
    }

}
