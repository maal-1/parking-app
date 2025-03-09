package se.lexicon.model;

public class ParkingSpot {
    private int spotNumber;
    private String areaCode;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, String areaCode) {
        this.spotNumber = spotNumber;
        this.areaCode = areaCode;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void vacate() {
        isOccupied = false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", areaCode='" + areaCode + '\'' +
                ", isOccupied=" + isOccupied +
                '}';
    }
}