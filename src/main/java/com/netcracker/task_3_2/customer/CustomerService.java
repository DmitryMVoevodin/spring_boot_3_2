package com.netcracker.task_3_2.customer;

import com.netcracker.task_3_2.exceptions.Flag;
import com.netcracker.task_3_2.exceptions.ResourceNotFoundException;
import com.netcracker.task_3_2.exceptions.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> allCust = customerRepository.findAll();
        for(Customer c : allCust) {
            customers.add(c);
        }
        return customers;
    }

    public ResponseEntity<Customer> getCustomerById(String customerId) throws ResourceNotFoundException {
        Integer customerIdInt = null;
        Customer customer = null;
        ResourceNotFoundException rnfe = new ResourceNotFoundException("There's no a customer for the id = " + customerId);
        try {
            customerIdInt = Integer.parseInt(customerId);
            customer = customerRepository.findById(customerIdInt).orElseThrow(() -> rnfe);
        } catch (NumberFormatException eNF) {
            throw rnfe;
        }
        return ResponseEntity.ok().body(customer);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Status deleteAllCustomers() {
        Status status = new Status();
        Iterable<Customer> allCust = customerRepository.findAll();
        boolean b = false;
        for(Customer c : allCust) {
            if (c.getCustomerId() > 0) {
                b = true;
                break;
            }
        }
        if(b) {
            customerRepository.deleteAll();
            status.setStatus(Flag.SUCCESSFULLY_DELETED);
        } else {
            status.setStatus(Flag.NOT_DELETED);
        }
        return status;
    }

    public Status deleteCustomerById(String customerId) {
        Status status = new Status();
        try {
            Integer customerIdInt = Integer.parseInt(customerId);
            if(customerRepository.existsById(customerIdInt)) {
                customerRepository.deleteById(customerIdInt);
                status.setStatus(Flag.SUCCESSFULLY_DELETED);
            } else {
                status.setStatus(Flag.NOT_DELETED);
            }
        } catch (NumberFormatException eNF) {
            status.setStatus(Flag.NOT_DELETED);
        }
        return status;
    }


}
