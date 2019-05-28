package com.netcracker.task_3_2.customer;

import com.netcracker.task_3_2.exceptions.ResourceNotFoundException;
import com.netcracker.task_3_2.exceptions.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Customer Controller", description = "Getting, adding and deleting customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Returns information about all the customers")
    @RequestMapping(method = RequestMethod.GET, value = "/rest/buyer")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiOperation(value = "Returns information about a customer using his id")
    @RequestMapping(method = RequestMethod.GET, value = "/rest/buyer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) throws ResourceNotFoundException {
        return customerService.getCustomerById(customerId);
    }

    @ApiOperation(value = "Adding a new customer")
    @RequestMapping(method = RequestMethod.POST, value = "/rest/buyer")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @ApiOperation(value = "Deleting all the customers and returning the status of the operation")
    @RequestMapping(method = RequestMethod.DELETE, value = "/rest/buyer")
    public Status deleteAllCustomers(){
        return customerService.deleteAllCustomers();
    }

    @ApiOperation(value = "Deleting a customer using his id and returning the status of the operation")
    @RequestMapping(method = RequestMethod.DELETE, value = "/rest/buyer/{customerId}")
    public Status deleteCustomerById(@PathVariable String customerId){
        return customerService.deleteCustomerById(customerId);
    }

}
