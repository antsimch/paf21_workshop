package sg.edu.nus.iss.paf21_workshop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf21_workshop.model.Customer;

@Repository
public class CustomerRepository {
    
    private JdbcTemplate template;

    private final String findAllSQL = "select * from customer";

    private final String findByIdSQL = "select * from customer where id = ?";

    private final String findAllLimitOffsetSQL = "select * from customer limit ? offset ?";

    public CustomerRepository(JdbcTemplate template) {
        this.template = template;
    }

    public List<Customer> getAllCustomers() {
        
        List<Customer> customers = new ArrayList<>();
        
        final SqlRowSet rs = template.queryForRowSet(findAllSQL);

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customers.add(customer);
        }

        return Collections.unmodifiableList(customers);
    }

    public List<Customer> getAllCustomersWithLimitOffset(int limit, int offset) {
        
        List<Customer> customers = new ArrayList<>();
        final SqlRowSet rs = template.queryForRowSet(findAllLimitOffsetSQL, limit, offset);

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customers.add(customer);
        }

        return Collections.unmodifiableList(customers);
    }

    public Customer getCustomerById(int customerId) {
        
        Customer customer = new Customer();

        customer = template.queryForObject(findByIdSQL, BeanPropertyRowMapper.newInstance(Customer.class), customerId);

        return customer;
    }
}
