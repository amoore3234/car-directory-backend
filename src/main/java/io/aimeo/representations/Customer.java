package io.aimeo.representations;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

public class Customer implements Serializable {
   @JsonProperty("customerID")
   private int customerID;

   @NotBlank
   @JsonProperty("firstName")
   @Length(min = 2, max = 50)
   private String firstName;

   @NotBlank
   @JsonProperty("lastName")
   @Length(min = 2, max = 50) 
   private String lastName;

   @NotBlank
   @JsonProperty("email")
   @Length(min = 2, max = 50)
   private String email;

   @NotBlank
   @JsonProperty("customerAddressOne")
   @Length(min = 2, max = 255)
   private String customerAddressOne;

   @JsonProperty("customerAddressTwo")
   @Length(min = 2, max = 10)
   private String customerAddressTwo;

   @NotBlank
   @JsonProperty("city")
   @Length(min = 2, max = 100)
   private String city;

   @NotBlank
   @JsonProperty("cState")
   @Length(min = 2, max = 4)
   private String cState;
   
   @NotBlank
   @JsonProperty("zipcode")
   @Length(min = 2, max = 10)
   private String zipcode;

   @NotBlank
   @JsonProperty("phoneNumber")
   @Length(min = 2, max = 30) 
   private String phone;

   public Customer () {
       this.customerID = 0;
       this.firstName = null;
       this.lastName = null;
       this.email = null;
       this.customerAddressOne = null;
       this.customerAddressTwo = null;
       this.city = null;
       this.cState = null;
       this.zipcode = null;
       this.phone = null;
   }

   public Customer (int customerID, String firstName, String lastName, String email, String customerAddressOne, String customerAddressTwo, String city, String cState, String zipcode, String phone) {
    this.customerID = customerID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.customerAddressOne = customerAddressOne;
    this.customerAddressTwo = customerAddressTwo;
    this.city = city;
    this.cState = cState;
    this.zipcode = zipcode;
    this.phone = phone;
    }

public int getCustomerID() {
    return customerID;
}

public void setCustomerID(int customerID) {
    this.customerID = customerID;
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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getCustomerAddressOne() {
    return customerAddressOne;
}

public void setCustomerAddressOne(String customerAddressOne) {
    this.customerAddressOne = customerAddressOne;
}

public String getCustomerAddressTwo() {
    return customerAddressTwo;
}

public void setCustomerAddressTwo(String customerAddressTwo) {
    this.customerAddressTwo = customerAddressTwo;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

public String getState() {
    return cState;
}

public void setState(String cState) {
    this.cState = cState;
}

public String getZipcode() {
    return zipcode;
}

public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

@Override
public String toString() {
    return "Customer [cState=" + cState + ", city=" + city + ", customerAddressOne=" + customerAddressOne
            + ", customerAddressTwo=" + customerAddressTwo + ", customerID=" + customerID + ", email=" + email
            + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", zipcode=" + zipcode + "]";
}

    
    
 
}
