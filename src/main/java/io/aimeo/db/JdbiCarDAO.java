package io.aimeo.db;

import java.util.List;

import org.jdbi.v3.core.Handle;

import io.aimeo.representations.Car;

public class JdbiCarDAO implements CarDAO {
    private final Handle handle;

    public JdbiCarDAO(Handle handle) {
        this.handle = handle;
    }

    public List<Car> getAll() {
        return handle.createQuery("select * from car")
                .mapTo(Car.class)
                .list();
    }

    public Car getById(int id) {
        return handle.createQuery("select * from car where carid = :id")
                .bind("id", id)
                .mapTo(Car.class)
                .one();
    }

    public List<Car> getCars(long limit, long offset, int pageID) {
        return handle.createQuery("select * from car LIMIT :limit OFFSET :offset")
                .bind("limit", limit)
                .bind("offset", offset)
                .bind("pageID", pageID)
                .mapTo(Car.class)
                .list();
    }

    public List<Car> getTrucks() {
        return handle.createQuery(
                "select * FROM car INNER JOIN categories ON car.categoryid = categories.categoryid WHERE categoryname = :name")
                .bind("name", "Trucks")
                .mapTo(Car.class)
                .list();
    }

    public List<Car> getSuvs() {
        return handle.createQuery(
                "select * FROM car INNER JOIN categories ON car.categoryid = categories.categoryid WHERE categoryname = :name")
                .bind("name", "SUVs")
                .mapTo(Car.class)
                .list();
    }

    public List<Car> getSedans() {
        return handle.createQuery(
                "select * FROM car INNER JOIN categories ON car.categoryid = categories.categoryid WHERE categoryname = :name")
                .bind("name", "Sedans")
                .mapTo(Car.class)
                .list();
    }
}
