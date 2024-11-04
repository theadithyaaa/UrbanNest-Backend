package edu.icet.service;

import edu.icet.dto.Customer;
import edu.icet.dto.Property;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    void addcustomer(Customer customer);
    void deletecustomerById(Integer id);
    Customer searchcustomerById(Integer id);
    void updatecustomerById(Customer customer);
}
