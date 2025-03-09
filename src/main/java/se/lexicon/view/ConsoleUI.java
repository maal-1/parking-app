package se.lexicon.view;

import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {


    private final Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        displayMessage("1. Register Customer");
        displayMessage("2. Display Parking Spots");
        displayMessage("3. Reserve a parking spot");
        displayMessage("4. Vacate a parking spot");
        displayMessage("5. Exit");
    }

    public Customer getCustomerInfoWithVehicle(){
        while (true) {
            try {
                scanner.nextLine();
                String name = getInput("Enter name:");
                String phoneNumber = getInput("Enter phone number:");
                String plateNumber = getInput("Enter plate number:");
                String vehicleType = getInput("Enter vehicle type (CAR, MOTORCYCLE, BUS):");

                return new Customer(
                        name,
                        phoneNumber,
                        new Vehicle(
                                VehicleType.valueOf(vehicleType),
                                plateNumber
                        )
                );
            } catch (IllegalArgumentException e) {
                displayErrorMessage(e.getMessage());
            }
        }
    }

    public String getInput(String prompt){
        String input;
        while (true){
            displayMessage(prompt);
            input = scanner.next().strip();

            //if input is not blank break the loop
            if (!input.isBlank())
                break;
            //else if input is blank print error message
            displayErrorMessage("Input cannot be empty. please try again.");
        }

        return input;
    }

    public void displayMessage(String message){
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RESET + message);
    }

    public void displaySuccessMessage(String message){
        final String ANSI_GREEN = "\u001B[32m";
        System.out.println(ANSI_GREEN + message);
    }

    public void displayErrorMessage(String message){
        final String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED + message);
    }


    public void displayParkingSpots(List<ParkingSpot> parkingSpots){
        displayMessage("Parking Spots:");
        parkingSpots.forEach(parkingSpot -> displayMessage(parkingSpot.toString()));
    }
}
