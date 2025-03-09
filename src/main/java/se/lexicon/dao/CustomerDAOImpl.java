package se.lexicon.dao;

import se.lexicon.dao.sequencer.CustomerIdSequencer;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO{

    //todo use a collection such as set to store unique customers
    private ArrayList<Customer> storage = new ArrayList<>();

    @Override
    public Customer saveCustomer(Customer customer) {
        if(customer == null)
            throw new IllegalArgumentException("Customer object is null");
        //todo implement duplicate check
        customer.setId(CustomerIdSequencer.nextCustomerId());
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        for (Customer customer : storage) {
            if(customer.getId() == id){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }
}
