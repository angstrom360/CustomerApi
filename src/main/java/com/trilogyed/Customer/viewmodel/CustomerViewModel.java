package com.trilogyed.Customer.viewmodel;

import com.trilogyed.Customer.model.Customer;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;
/**The Comment ViewModel is a POJO, that contains Bean Validations and will be used to help build the Service Layer  */

public class CustomerViewModel {

    private int customerId;
    @NotEmpty(message = "Please supply the First Name.")
    private String firstName;
    @NotEmpty(message = "Please supply the Last Name.")
    private String lastName;
    @NotEmpty(message = "Please supply the Street.")
    private String street;
    @NotEmpty(message = "Please supply the City.")
    private String city;
    @NotEmpty(message = "Please supply the Zip.")
    private String zip;
    @NotEmpty(message = "Please supply the Email.")
    private String email;
    @NotEmpty(message = "Please supply the Phone.")
    private String phone;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerViewModel that = (CustomerViewModel) o;
        return customerId == that.customerId &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                zip.equals(that.zip) &&
                email.equals(that.email) &&
                phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, street, city, zip, email, phone);
    }
}
