package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer testObject;

    @BeforeEach
    void setUp() {
        testObject = new Customer(
                "Mike Torsion",
                " 076 1234567 ",
                1,
                new Vehicle(
                        VehicleType.CAR,
                        "ABC123"
                )
        );
    }

    @Test
    void testCustomerCreation() {
        assertEquals(1, testObject.getId());
        assertEquals("Mike Torsion", testObject.getName());
        assertEquals("0761234567", testObject.getPhoneNumber());
    }

    @Test
    void testValidPhoneNumber() {
        testObject.setPhoneNumber(" 0767654321 ");
        assertEquals("0767654321", testObject.getPhoneNumber());
    }

    @Test
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> testObject.setPhoneNumber(" 07600 "));
    }

    @Test
    void testSetNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> testObject.setPhoneNumber(null));
    }

    @Test
    void testSetName() {
        testObject.setName("Eva Torsion");
        assertEquals("Eva Torsion", testObject.getName());
    }

    @Test
    void testSetInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> testObject.setName("E"));
        assertThrows(IllegalArgumentException.class, () -> testObject.setName(null));
        assertThrows(IllegalArgumentException.class, () -> testObject.setName(""));
    }
}