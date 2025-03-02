package se.lexicon.model;

public class Customer {

    private final Integer id;
    private String name;
    private String phoneNumber;
    private Vehicle vehicle;


    public Customer(String name, String phoneNumber, Vehicle vehicle) {
        //todo: implement id generator
        id = 0;
        setName(name);
        setPhoneNumber(phoneNumber);
        setVehicle(vehicle);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        //todo: implement validation
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        //remove leading and trailing white spaces
        name = name.strip();

        //check if name is null or empty
        if (isNullOrBlank(name))
            throw new IllegalArgumentException("Name is null or empty");

        //check if name is less than 2 characters
        if (name.length() < 2)
            throw new IllegalArgumentException("Name is too short");

        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        //check if phone number is null or empty
        if (isNullOrBlank(phoneNumber))
            throw new IllegalArgumentException("Name is null or empty");

        //remove all white spaces
        phoneNumber = phoneNumber.replaceAll("\\s", "");

        //check if phone number is not 10-13 digits
        if (!phoneNumber.matches("\\+?\\d{10,13}"))
            throw new IllegalArgumentException("Phone number should be 10 digits");

        this.phoneNumber = phoneNumber;
    }

    private boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
