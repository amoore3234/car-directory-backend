package io.aimeo.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import io.aimeo.representations.Customer;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    private Client client;

    public ClientResource(Client client) {
        this.client = client;
    }

    @GET
    @Path("showCustomer")
    public String showCustomer(@QueryParam("customerid") int customerID) {
        String url = "http://localhost:8080/customer/" + customerID;
        WebTarget target = client.target(url);
        Invocation.Builder iBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = iBuilder.get();
        Customer c = response.readEntity(Customer.class);
        String output = "ID: " + customerID
                        +"\nFirst name: " + c.getFirstName()
                        +"\nLast name: " + c.getLastName()
                        +"\nEmail: " + c.getEmail()
                        +"\nAddress 1: " + c.getCustomerAddressOne()
                        +"\nAddress 2: " + c.getCustomerAddressTwo()
                        +"\nCity: " + c.getCity()
                        +"\nState: " + c.getState()
                        +"\nZipcode: " + c.getZipcode() 
                        +"\nPhone: " + c.getPhone();
        return output;
    }

    @GET
    @Path("allCustomers")
    public List<Customer> getAll() {
        String url = "http://localhost:8080/customer/all";
        WebTarget target = client.target(url);
        Invocation.Builder iBuilder = target.request(MediaType.APPLICATION_JSON);
        Response response = iBuilder.get();
        List<Customer> customers = response.readEntity(new GenericType<List<Customer>>() {});

        return customers;
    } 

    @GET
    @Path("newCustomer")
    public Response newCustomer(
        @QueryParam("firstName") String firstName, 
        @QueryParam("lastName") String lastName, 
        @QueryParam("email") String email, 
        @QueryParam("customeraddressone") String customerAddressOne, 
        @QueryParam("customeraddresstwo") String customerAddressTwo, 
        @QueryParam("city") String city, 
        @QueryParam("cState") String cState,
        @QueryParam("zipcode") String zipcode, 
        @QueryParam("phone") String phone) {
            String url = "http://localhost:8080/customer";
            WebTarget target = client.target(url);
            Invocation.Builder iBuilder = target.request(MediaType.APPLICATION_JSON);
            Customer customer = new Customer(0, firstName, lastName, email, customerAddressOne, customerAddressTwo, city, cState, zipcode, phone);
            Response response = iBuilder.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
            try {
                if (response.getStatus() == 201) {
                    // Created
                    return Response.status(201).entity("The customer was created successfully. The new customer can " + 
                                                        "be found at " + response.getHeaders().getFirst("Location")).build();
                } else {
                    // Other Status code, indicates an error
                    return Response.status(422).entity(String.class).build();
                } 
            } finally {
                        response.close();
                }
        }

    @GET
    @Path("updateCustomer")
    public Response updateCustomer(
        @QueryParam("customerid") int customerID, 
        @QueryParam("firstName") String firstName, 
        @QueryParam("lastName") String lastName, 
        @QueryParam("email") String email, 
        @QueryParam("customeraddressone") String customerAddressOne, 
        @QueryParam("customeraddresstwo") String customerAddressTwo, 
        @QueryParam("city") String city, 
        @QueryParam("cState") String cState,
        @QueryParam("zipcode") String zipcode, 
        @QueryParam("phone") String phone) {
            String url = "http://localhost:8080/customer/" + customerID;
            WebTarget target = client.target(url);
            Invocation.Builder iBuilder = target.request(MediaType.APPLICATION_JSON);
            Customer customer = new Customer(0, firstName, lastName, email, customerAddressOne, customerAddressTwo, city, cState, zipcode, phone);
            Response response = iBuilder.put(Entity.entity(customer, MediaType.APPLICATION_JSON));
            try {
                if (response.getStatus() == 200) {
                    // Created
                    return Response.status(200).entity("The customer was updated successfully!" + response).build();
                } else {
                    // Other Status code, indicates an error
                    return Response.status(422).entity(String.class).build();
                }
            } finally {
                    response.close();
                }
        }

    @GET
    @Path("deleteCustomer")
    public Response deletecustomer(@QueryParam("customerid") int customerID) {
        WebTarget target = client.target("http://localhost:8080/customer/"+ customerID);
        Invocation.Builder iBuilder = target.request();
        Response response = iBuilder.delete();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        return Response.noContent().entity("customer was deleted!").build();
    }
}
