package se.lexicon.dao;

import se.lexicon.model.Customer;

import java.util.Optional;

public interface CustomerDAO {


    Customer saveCustomer(Customer customer);
    Optional<Customer>  findCustomerById(int in);

}
