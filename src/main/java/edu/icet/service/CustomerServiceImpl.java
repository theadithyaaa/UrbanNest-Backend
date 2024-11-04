package edu.icet.service;

import edu.icet.dto.Customer;
import edu.icet.dto.Property;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.PropertyEntity;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Customer> getAll() {
        List<Customer> customerArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            customerArrayList.add(mapper.map(entity, Customer.class));
        });
        return customerArrayList;
    }

    @Override
    public void addcustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));


    }

    @Override
    public void deletecustomerById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Customer searchcustomerById(Integer id) {
        return mapper.map(repository.findById(id),Customer.class);

    }

    @Override
    public void updatecustomerById(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));

    }
}
