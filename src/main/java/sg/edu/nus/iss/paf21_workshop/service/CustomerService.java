package sg.edu.nus.iss.paf21_workshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf21_workshop.model.Customer;
import sg.edu.nus.iss.paf21_workshop.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    public List<Customer> getAllCustomersWithLimitOffset(int limit, int offset) {
        return customerRepo.getAllCustomersWithLimitOffset(limit, offset);
    }

    public Customer getCustomerById(int customerId) {
        return customerRepo.getCustomerById(customerId);
    }
}
