package com.pukar.bankemployeedepartment.service;

import com.pukar.bankemployeedepartment.entity.Customer;
import com.pukar.bankemployeedepartment.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Customer createCustomer(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }


    @Override
    public List<Customer> allCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepo.findById(id).orElseThrow(()-> new RuntimeException(String.format("No customer found for id: ", id)));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer savedCustomer = customerRepo.findById(customer.getCustomerId()).orElseThrow(()-> new RuntimeException("No customer for id: "));
        savedCustomer.setCustomerFullName(customer.getCustomerFullName());
        savedCustomer.setPhNumber(customer.getPhNumber());
        savedCustomer.setSalary(customer.getSalary());
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepo.deleteById(id);
    }
}
