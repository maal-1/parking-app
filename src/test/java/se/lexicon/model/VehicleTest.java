package se.lexicon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testVehicleCreation() {
        Vehicle vehicle = new Vehicle(VehicleType.CAR, "ABC123");
        assertEquals(VehicleType.CAR, vehicle.getVehicleType());
        assertEquals("ABC123", vehicle.getPlateNumber());
    }

    @Test
    void testVehicleCreation_null_plateNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(VehicleType.CAR, null));
    }

    @Test
    void testVehicleCreation_blank_plateNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(VehicleType.CAR, ""));
    }

    @Test
    void testVehicleCreation_null_vehicleType() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(null, "ABC123"));
    }

    @Test
    void testVehicleCreation_blank_vehicleType() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(VehicleType.valueOf(""), "ABC123"));
    }

    @Test
    void testVehicleCreation_blank_vehicleType_and_plateNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(VehicleType.valueOf(""), ""));
    }
}