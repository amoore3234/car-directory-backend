package io.aimeo.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import io.aimeo.representations.Car;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {
        Car car = new Car();
        car.setCarID(rs.getInt("carid"));
        car.setCategoryID(rs.getInt("categoryid"));
        car.setVin(rs.getString("vin"));
        car.setCarName(rs.getString("carname"));
        car.setCarModel(rs.getString("carmodel"));
        car.setCarYear(rs.getInt("caryear"));
        car.setCarExterior(rs.getString("carexterior"));
        car.setCarInterior(rs.getString("carinterior"));
        car.setCarLocation(rs.getString("carlocation"));
        car.setPrice(rs.getInt("price"));
        return car;
    }

}
