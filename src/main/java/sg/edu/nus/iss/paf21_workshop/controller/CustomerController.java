package sg.edu.nus.iss.paf21_workshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf21_workshop.model.Customer;
import sg.edu.nus.iss.paf21_workshop.service.CustomerService;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/limit")
    public List<Customer> getAllCustomersWithLimitOffset(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        return customerService.getAllCustomersWithLimitOffset(limit, offset);
    }

    @GetMapping(path = "/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return customerService.getCustomerById(customerId);
    }
}
