package org.cid;

import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ParkingLotManager parkingLotManager = ParkingLotManager.getParkingLotManager();

        while (true) {
            String input = scanner.nextLine();
            List<String> inputList = Arrays.stream(input.split(" ")).toList();

            if(Objects.equals(inputList.get(0), "create_parking_lot")){
                parkingLotManager.createParkingLot(inputList.get(1), Integer.parseInt(inputList.get(2)), Integer.parseInt(inputList.get(3)));
            }

            if(Objects.equals(inputList.get(0), "park_vehicle")){
                parkingLotManager.parkVehicle(inputList.get(1), inputList.get(2), inputList.get(3));
            }

            if(Objects.equals(inputList.get(0), "unpark_vehicle")){
                parkingLotManager.unparkVehicle(inputList.get(1));
            }

            if(Objects.equals(inputList.get(0), "display")){
                parkingLotManager.display(inputList.get(1), inputList.get(2));
            }

            if(Objects.equals(inputList.get(0), "exit")){
                break;
            }
        }
    }
}