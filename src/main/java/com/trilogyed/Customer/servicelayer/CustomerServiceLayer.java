package com.trilogyed.Customer.servicelayer;

import com.trilogyed.Customer.dao.CustomerDao;
import com.trilogyed.Customer.model.Customer;
import com.trilogyed.Customer.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RefreshScope
public class CustomerServiceLayer {
    /**------------- Importing all objects and variables that will be used to build the ServiceLayer----------------- */
    @Autowired CustomerDao customerDao;

    @Autowired
    public CustomerServiceLayer(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    private CustomerViewModel buildCustomerViewModel (Customer customer){
        CustomerViewModel customerViewModel = new CustomerViewModel();
        customerViewModel.setCustomerId(customer.getCustomerId());
        customerViewModel.setFirstName(customer.getFirstName());
        customerViewModel.setLastName(customer.getLastName());
        customerViewModel.setStreet(customer.getStreet());
        customerViewModel.setCity(customer.getCity());
        customerViewModel.setZip(customer.getZip());
        customerViewModel.setEmail(customer.getEmail());
        customerViewModel.setPhone(customer.getPhone());

        return customerViewModel;
    }
    /**---------------------------------------------------------------------------------------------------------------*/

    /**The Business Logic for the service Layer is CRUD */
    @Transactional
    public CustomerViewModel createCustomer(CustomerViewModel customerViewModel){
        Customer customer = new Customer();
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setStreet(customerViewModel.getStreet());
        customer.setCity(customerViewModel.getCity());
        customer.setZip(customerViewModel.getZip());
        customer.setEmail(customerViewModel.getEmail());
        customer.setPhone(customerViewModel.getPhone());
        customer = customerDao.createCustomer(customer);
        customerViewModel.setCustomerId(customer.getCustomerId());

        return customerViewModel;
    }

    public CustomerViewModel getCustomer(int id){
        Customer customer = customerDao.getCustomer(id);
        if(customer == null)
            return null;
        else
            return buildCustomerViewModel(customer);

    }

    public List<CustomerViewModel> getAllCustomer(){
        List<Customer> customerList = customerDao.getAllCustomers();
        List<CustomerViewModel> customerViewModelList = new ArrayList<>();

        for(Customer cList : customerList){
            CustomerViewModel customerViewModel = buildCustomerViewModel(cList);
            customerViewModelList.add(customerViewModel);
        }

        return customerViewModelList;
    }

    public void updateCustomer(CustomerViewModel customerViewModel){
        Customer customer = new Customer();
        customer.setCustomerId(customerViewModel.getCustomerId());
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setStreet(customerViewModel.getStreet());
        customer.setCity(customerViewModel.getCity());
        customer.setZip(customerViewModel.getZip());
        customer.setEmail(customerViewModel.getEmail());
        customer.setPhone(customerViewModel.getPhone());
        customerDao.updateCustomer(customer);

    }
    public void deleteCustomer(int id){
        customerDao.deleteCustomer(id);
    }



}
