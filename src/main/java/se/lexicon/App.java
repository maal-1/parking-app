package se.lexicon;

import se.lexicon.controller.ParkingController;

public class App {

    public static void main(String[] args) {

//        Customer customer = new Customer("Mike Torsson", " 076 1234567 ");
//        Customer customer2 = new Customer("Evs Torsson", " +46 76 4567890 ");
//        System.out.println(customer);
//        System.out.println(customer2);

//        ConsoleUI consoleUI = new ConsoleUI();
//        consoleUI.displayMessage("Hello World!");
//        consoleUI.displaySuccessMessage("Success Message");
//        consoleUI.displayErrorMessage("Error Message");
//        consoleUI.displayMessage("Hello World!");

        ParkingController parkingController = new ParkingController();
        parkingController.run();
    }

}
