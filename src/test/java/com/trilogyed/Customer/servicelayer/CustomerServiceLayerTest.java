package com.trilogyed.Customer.servicelayer;


import com.trilogyed.Customer.dao.CustomerDao;
import com.trilogyed.Customer.dao.CustomerDaoJdbcTemplate;
import com.trilogyed.Customer.model.Customer;
import com.trilogyed.Customer.viewmodel.CustomerViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CustomerServiceLayerTest {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerServiceLayer customerServiceLayer;

    private void setUpCustomerDaoMock(){
        customerDao = mock(CustomerDaoJdbcTemplate.class);

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Mighty");
        customer.setLastName("Jones");
        customer.setStreet("Langley");
        customer.setCity("Michigan");
        customer.setZip("818112");
        customer.setEmail("mightyJones@yahoo.com");
        customer.setPhone("913-456-8215");

        Customer customer1 = new Customer();
        customer1.setFirstName("Mighty");
        customer1.setLastName("Jones");
        customer1.setStreet("Langley");
        customer1.setCity("Michigan");
        customer1.setZip("818112");
        customer1.setEmail("mightyJones@yahoo.com");
        customer1.setPhone("913-456-8215");

        List<Customer> cList = new ArrayList<>();
        cList.add(customer);

        doReturn(customer).when(customerDao).createCustomer(customer1);
        doReturn(customer).when(customerDao).getCustomer(1);
        doReturn(cList).when(customerDao).getAllCustomers();

    }

    @Before
    public void setUp()throws Exception{
        setUpCustomerDaoMock();
        customerServiceLayer = new CustomerServiceLayer(customerDao);
    }

    @Test
    public void createCustomer(){
        CustomerViewModel customer = new CustomerViewModel();
        customer.setCustomerId(1);
        customer.setFirstName("Mighty");
        customer.setLastName("Jones");
        customer.setStreet("Langley");
        customer.setCity("Michigan");
        customer.setZip("818112");
        customer.setEmail("mightyJones@yahoo.com");
        customer.setPhone("913-456-8215");
        customer = customerServiceLayer.createCustomer(customer);

        CustomerViewModel customer1 = new CustomerViewModel();
        customer1.setCustomerId(1);
        customer1.setFirstName("Mighty");
        customer1.setLastName("Jones");
        customer1.setStreet("Langley");
        customer1.setCity("Michigan");
        customer1.setZip("818112");
        customer1.setEmail("mightyJones@yahoo.com");
        customer1.setPhone("913-456-8215");

        CustomerViewModel fromService = customerServiceLayer.createCustomer(customer1);
        assertEquals(customer,fromService);

    }

    @Test
    public void getCustomer(){

        CustomerViewModel customer = new CustomerViewModel();
        customer.setCustomerId(1);
        customer.setFirstName("Mighty");
        customer.setLastName("Jones");
        customer.setStreet("Langley");
        customer.setCity("Michigan");
        customer.setZip("818112");
        customer.setEmail("mightyJones@yahoo.com");
        customer.setPhone("913-456-8215");
        customer = customerServiceLayer.createCustomer(customer);

        CustomerViewModel fromService = customerServiceLayer.getCustomer(1);
        assertEquals(customer,fromService);

    }

    @Test
    public void getAllCustomer(){

        CustomerViewModel customer = new CustomerViewModel();
        customer.setCustomerId(1);
        customer.setFirstName("Mighty");
        customer.setLastName("Jones");
        customer.setStreet("Langley");
        customer.setCity("Michigan");
        customer.setZip("818112");
        customer.setEmail("mightyJones@yahoo.com");
        customer.setPhone("913-456-8215");
        customer = customerServiceLayer.createCustomer(customer);

        List<CustomerViewModel> fromService = customerServiceLayer.getAllCustomer();
        assertEquals(1,fromService.size());
        assertEquals(customer,fromService.get(0));

    }

}
