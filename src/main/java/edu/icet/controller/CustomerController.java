package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    final CustomerService service;

    @GetMapping("/customer/get-all")
    public List<Customer> getCustomer(){
        return service.getAll();
    }

    @PostMapping("/customer/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addcustomer(@RequestBody Customer customer){
        service.addcustomer(customer);
    }

    @GetMapping("/customers/search-by-id/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return service.searchcustomerById(id);
    }

    @DeleteMapping("/customers/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomerById(@PathVariable Integer id){
        service.deletecustomerById(id);
    }
    @PutMapping("/customers/update-customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCustomer(@RequestBody Customer customer){
        service.updatecustomerById(customer);
    }

}
