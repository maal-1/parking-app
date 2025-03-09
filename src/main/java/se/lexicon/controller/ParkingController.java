package se.lexicon.controller;

import se.lexicon.dao.CustomerDAO;
import se.lexicon.dao.CustomerDAOImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class ParkingController {

    ConsoleUI consoleUI;
    CustomerDAO customerDao;
    List<ParkingSpot> parkingSpots;

    public ParkingController() {
        consoleUI = new ConsoleUI();
        customerDao = new CustomerDAOImpl();

        //todo move data to database
        parkingSpots = new ArrayList<>();
        // Initialize some parking spots for demonstration
        parkingSpots.add(new ParkingSpot(1, "A1"));
        parkingSpots.add(new ParkingSpot(2, "A2"));
        parkingSpots.add(new ParkingSpot(3, "B1"));
        parkingSpots.add(new ParkingSpot(4, "B2"));
    }


    public void run() {
        boolean running = true;
        while (running) {
            consoleUI.displayMenu();
            String choice = consoleUI.getInput("Choose an option: "); // get use choice

            switch (choice) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    displayParkingSpots();
                    break;
                case "3":
                    reserveParkingSpot();
                    break;
                case "4":
                    vacateParkingSpot();
                    break;
                case "5": {
                    consoleUI.displayMessage("Exiting the app. Goodbye!");
                    running = false;
                    break;
                }
                default:
                    consoleUI.displayMessage("Invalid Option. Please try again.");
            }


        }
    }

    private void registerCustomer() {

        Customer customerData = consoleUI.getCustomerInfoWithVehicle();
        Customer createdCustomer = customerDao.saveCustomer(customerData);
        consoleUI.displaySuccessMessage("Customer registered successfully with Id: " + createdCustomer.getId());

    }


    private void displayParkingSpots() {
        consoleUI.displayParkingSpots(parkingSpots);
    }


    private void reserveParkingSpot() {
        int spotNumber = Integer.parseInt(consoleUI.getInput("Enter spot number to reserve: "));
        //todo UI should ask for customer id

        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                if (!spot.isOccupied()) {
                    spot.occupy();
                    consoleUI.displaySuccessMessage("Parking spot " + spotNumber + " reserved successfully.");
                } else {
                    consoleUI.displayErrorMessage("Parking spot " + spotNumber + " is already occupied.");
                }
                return;
            }
        }
        consoleUI.displayErrorMessage("Parking spot " + spotNumber + " not found.");
    }


    private void vacateParkingSpot() {
        int spotNumber = Integer.parseInt(consoleUI.getInput("Enter spot number to vacate: "));
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                if (spot.isOccupied()) {
                    spot.vacate();
                    consoleUI.displaySuccessMessage("Parking spot " + spotNumber + " vacated successfully.");
                } else {
                    consoleUI.displayErrorMessage("Parking spot " + spotNumber + " is already vacant.");
                }
                return;
            }
        }
        consoleUI.displayErrorMessage("Parking spot " + spotNumber + " not found.");


    }


}