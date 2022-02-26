package io.aimeo.db;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import io.aimeo.Mappers.CustomerMapper;
import io.aimeo.representations.Customer;


public interface CustomerDAO {
    @RegisterRowMapper(CustomerMapper.class)
    @SqlQuery("select * from customer where customerid = :customerid")
    Customer getCustomerID(@Bind("customerid") int customerID);

    @RegisterBeanMapper(Customer.class)
    @SqlQuery("select * from customer")
    List<Customer> getAll();

    @GetGeneratedKeys
    @SqlUpdate("insert into customer (firstname, lastname, email, customeraddressone, customeraddresstwo, city, cstate, zipcode, phone)" +
                " values (:firstname, :lastname, :email, :customeraddressone, :customeraddresstwo, :city, :cstate, :zipcode, :phone)")
                int createCustomer(@Bind("firstname") String firstname, @Bind("lastname") String lastname, @Bind("email") String email,
                                    @Bind("customeraddressone") String customerAddressOne, @Bind("customeraddresstwo") String customerAddressTwo, 
                                    @Bind("city") String city, @Bind("cstate") String cState, @Bind("zipcode") String zipcode, @Bind("phone") String phone);
    
    @SqlUpdate("update customer set customerid = :customerid, firstname = :firstname, lastname = :lastname, email = :email, customeraddressone = :customeraddressone, " + 
                "customeraddresstwo = :customeraddresstwo, city = :city, cstate = :cstate, zipcode = :zipcode, phone = :phone where customerid = :customerid")
                void updateCustomer(@Bind("customerid") int customerID, @Bind("firstname") String firstname, @Bind("lastname") String lastname, @Bind("email") String email,
                @Bind("customeraddressone") String customerAddressOne, @Bind("customeraddresstwo") String customerAddressTwo, 
                @Bind("city") String city, @Bind("cstate") String cState, @Bind("zipcode") String zipcode, @Bind("phone") String phone);

    @SqlUpdate("delete from customer where customerid = :customerid")
    void deleteCustomer(@Bind("customerid") int customerID);
    
}
