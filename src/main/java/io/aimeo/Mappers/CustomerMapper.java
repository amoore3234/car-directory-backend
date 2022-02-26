package io.aimeo.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import io.aimeo.representations.Customer;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer map(ResultSet rs, StatementContext ctx) throws SQLException {
        
        return new Customer(rs.getInt("customerid"), rs.getString("firstName"), rs.getString("lastName"), 
                            rs.getString("email"), rs.getString("customeraddressone"), rs.getString("customeraddresstwo"), 
                            rs.getString("city"), rs.getString("cstate"), rs.getString("zipcode"), rs.getString("phone"));
    }
    
}
