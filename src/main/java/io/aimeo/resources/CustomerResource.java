package io.aimeo.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Jdbi;

import io.aimeo.db.CustomerDAO;
import io.aimeo.representations.Customer;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    private final CustomerDAO customerDAO;

    public CustomerResource(Jdbi jdbi, Validator validator) {
        customerDAO = jdbi.onDemand(CustomerDAO.class);
    }

    @GET
    @Path("/{customerid}")
    public Response getCustomerID(@PathParam("customerid") int customerID) {
        Customer customer = customerDAO.getCustomerID(customerID);
        return Response
                .ok(customer)
                .build();
    }

    @GET
    @Path("/all")
    public Response getAll() {
        List<Customer> customers = customerDAO.getAll();
        return Response
                .ok(customers)
                .build();
    }

    @POST
    public Response createCustomer(@Valid Customer customer) throws URISyntaxException {
        int newCustomerID = customerDAO.createCustomer(customer.getFirstName(), customer.getLastName(), 
        customer.getEmail(), customer.getCustomerAddressOne(), customer.getCustomerAddressTwo(), 
        customer.getCity(), customer.getState(), customer.getZipcode(), customer.getPhone());

        return Response.created(new URI(String.valueOf(newCustomerID))).build();
    }

    @PUT
    @Path("/{customerid}")
    public Response updateCustomer(@PathParam("customerid") int customerID, Customer customer) {
        customerDAO.updateCustomer(customerID, customer.getFirstName(), customer.getLastName(), 
        customer.getEmail(), customer.getCustomerAddressOne(), customer.getCustomerAddressTwo(), 
        customer.getCity(), customer.getState(), customer.getZipcode(), customer.getPhone());

        return Response
            .ok(new Customer(customerID, customer.getFirstName(), customer.getLastName(), 
            customer.getEmail(), customer.getCustomerAddressOne(), customer.getCustomerAddressTwo(), 
            customer.getCity(), customer.getState(), customer.getZipcode(), customer.getPhone()))
            .build();
    }

    @DELETE
    @Path("/{customerid}")
    public Response deleteCustomer(@PathParam("customerid") int customerID) {
        customerDAO.deleteCustomer(customerID);
        return Response.noContent().build();
    }

}
