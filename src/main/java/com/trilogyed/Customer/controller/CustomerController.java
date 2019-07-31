package com.trilogyed.Customer.controller;


import com.sun.jersey.api.NotFoundException;
import com.trilogyed.Customer.servicelayer.CustomerServiceLayer;
import com.trilogyed.Customer.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    /**----------------------------------- REST CONTROLLER ----------------------------------------------------------*/
    @Autowired
    CustomerServiceLayer service;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public CustomerViewModel createCustomers(@RequestBody @Valid CustomerViewModel customerViewModel){
        return service.createCustomer(customerViewModel);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public CustomerViewModel getCustomers(@PathVariable int id){
        CustomerViewModel customerViewModel = service.getCustomer(id);
        if(customerViewModel == null)
            throw new NotFoundException("Customer could not be found for id "+id);
        return customerViewModel;

    }

    @RequestMapping(value = "/customers/all", method = RequestMethod.GET)
    public List<CustomerViewModel> getAllCustomer(){
        return service.getAllCustomer();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public void updateCustomers(@RequestBody @Valid CustomerViewModel customerViewModel, @PathVariable int id) {
        if(customerViewModel.getCustomerId() == 0)
            customerViewModel.setCustomerId(id);
        if(id != customerViewModel.getCustomerId()) {

            throw new IllegalArgumentException("Post ID on path must match the ID in the Post Object.");
        }
        service.updateCustomer(customerViewModel);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        service.deleteCustomer(id);

    }

    /**----------------------------------------------------------------------------------------------------------------*/

}
