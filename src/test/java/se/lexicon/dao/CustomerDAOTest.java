package se.lexicon.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.sequencer.CustomerIdSequencer;
import se.lexicon.model.Customer;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    CustomerDAO testObject;
    Customer customer;

    @BeforeEach
    void setUp() {
        testObject = new CustomerDAOImpl();
        customer = new Customer(
                "Mike Torsion",
                " 076 1234567 ",
                5,
                new Vehicle(
                        VehicleType.CAR,
                        "ABC123"
                )
        );
    }

    @AfterEach
    void tearDown() {
        testObject = null;
        customer = null;
        CustomerIdSequencer.reset();
    }

    @Test
    void testAddingValidCustomer() {
        testObject.saveCustomer(customer);
        assertEquals(1, customer.getId());

    }


    @Test
    void testAddingInvalidCustomer() {
        customer = null;
        assertThrows(IllegalArgumentException.class, () -> testObject.saveCustomer(customer));

    }

    @Test
    void findByIdExistedCustomer() {
        testObject.saveCustomer(customer);
        assertTrue(testObject.findCustomerById(1).isPresent());
    }

    @Test
    void findByIdNotExistedCustomer() {
        assertFalse(testObject.findCustomerById(2).isPresent());
    }


}