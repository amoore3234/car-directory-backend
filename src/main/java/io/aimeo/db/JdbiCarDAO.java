package io.aimeo.db;

import java.util.List;

import org.jdbi.v3.core.Jdbi;

import io.aimeo.representations.Car;

public class JdbiCarDAO implements CarDAO {
    private final Jdbi jdbi;

    public JdbiCarDAO(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Car> getAll() {
        return jdbi.withHandle(handle -> {
            List<Car> getCars = handle.createQuery("select * from car")
                .mapTo(Car.class)
                .list();
                
            return getCars;
            
        });
    }

    public Car getById(int id) {
        return jdbi.withHandle(handle -> {
            Car carById = handle.createQuery("select * from car where carid = :id")
                .bind("id", id)
                .mapTo(Car.class)
                .one();
            
            return carById;
        });
    }

    public List<Car> getCars(long limit, long offset, int pageID) {
        return jdbi.withHandle(handle -> {
            List<Car> getCars = handle.createQuery("select * from car LIMIT :limit OFFSET :offset")
                .bind("limit", limit)
                .bind("offset", offset)
                .bind("pageID", pageID)
                .mapTo(Car.class)
                .list();

            return getCars;
        });
    }

    public List<Car> getTrucks() {
        return jdbi.withHandle(handle -> {
            List<Car> getTrucks = handle.createQuery(
                "select * FROM car INNER JOIN categories ON car.categoryid = categories.categoryid WHERE categoryname = :name")
                .bind("name", "Trucks")
                .mapTo(Car.class)
                .list();
                
            return getTrucks;
        });
    }

    public List<Car> getSuvs() {
        return jdbi.withHandle(handle -> {
            List<Car> getSuvs = handle.createQuery(
                "select * FROM car INNER JOIN categories ON car.categoryid = categories.categoryid WHERE categoryname = :name")
                .bind("name", "SUVs")
                .mapTo(Car.class)
                .list();
                
            return getSuvs;
        });
    }

    public List<Car> getSedans() {
        return jdbi.withHandle(handle -> {
            List<Car> getSedans = handle.createQuery(
                "select * FROM car INNER JOIN categories ON car.categoryid = categories.categoryid WHERE categoryname = :name")
                .bind("name", "Sedans")
                .mapTo(Car.class)
                .list();

                return getSedans;
        });
    }
}
