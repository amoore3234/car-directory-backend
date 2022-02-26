package io.aimeo.db;

import java.util.List;

import io.aimeo.representations.Car;

public interface CarDAO {
    public List<Car> getAll();

    public Car getById(int id);

    public List<Car> getCars(long limit, long offset, int pageID);

    public List<Car> getTrucks();

    public List<Car> getSuvs();

    public List<Car> getSedans();
}
