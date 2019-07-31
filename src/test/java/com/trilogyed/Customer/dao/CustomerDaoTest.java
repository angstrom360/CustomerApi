package com.trilogyed.Customer.dao;


import com.trilogyed.Customer.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Before
    public void SetUp() throws Exception{

        List<Customer> cList = customerDao.getAllCustomers();

        for(Customer c : cList){
            customerDao.deleteCustomer(c.getCustomerId());
        }

    }

    @Test
    public void addGetDeleteCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Mighty");
        customer.setLastName("Jones");
        customer.setStreet("Langley");
        customer.setCity("Michigan");
        customer.setZip("818112");
        customer.setEmail("mightyJones@yahoo.com");
        customer.setPhone("913-456-8215");
        customer = customerDao.createCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getCustomerId());

        assertEquals(customer1,customer);

        customerDao.deleteCustomer(customer.getCustomerId());

        customer1 = customerDao.getCustomer(customer.getCustomerId());

        assertNull(customer1);

    }

    @Test
    public void getAllCustomers(){

        Customer customer = new Customer();
        customer.setFirstName("Mighty");
        customer.setLastName("Jones");
        customer.setStreet("Langley");
        customer.setCity("Michigan");
        customer.setZip("818112");
        customer.setEmail("mightyJones@yahoo.com");
        customer.setPhone("913-456-8215");
        customer = customerDao.createCustomer(customer);

        customer =new Customer();
        customer.setFirstName("Kind");
        customer.setLastName("Charles");
        customer.setStreet("Jefferson");
        customer.setCity("Detroit");
        customer.setZip("818162");
        customer.setEmail("kindCharles@yahoo.com");
        customer.setPhone("917-454-8274");
        customerDao.createCustomer(customer);

        List<Customer> cList = customerDao.getAllCustomers();

        assertEquals(cList.size(),2);
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Kind");
        customer.setLastName("Charles");
        customer.setStreet("Jefferson");
        customer.setCity("Detroit");
        customer.setZip("818162");
        customer.setEmail("kindCharles@yahoo.com");
        customer.setPhone("917-454-8274");
        customer = customerDao.createCustomer(customer);

        customer.setCity("Boston");
        customerDao.updateCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getCustomerId());

        assertEquals(customer1,customer);
    }



}
