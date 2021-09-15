package com.pukar.bankemployeedepartment.controller;

import com.pukar.bankemployeedepartment.entity.Customer;
import com.pukar.bankemployeedepartment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> allCustomer(){
        return customerService.allCustomer();
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getById(@PathVariable long id){
        return  customerService.getCustomerById(id);
    }

    @PutMapping("/customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }
}
