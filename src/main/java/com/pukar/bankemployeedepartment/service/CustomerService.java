package com.pukar.bankemployeedepartment.service;

import com.pukar.bankemployeedepartment.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer);
    List<Customer> allCustomer();
    public Customer getCustomerById(long id);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(long id);

}
