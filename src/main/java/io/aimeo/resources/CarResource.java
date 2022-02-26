package io.aimeo.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import io.aimeo.db.CarDAO;
import io.aimeo.representations.Car;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private Jdbi jdbi;

    public CarResource(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @GET
    @Path("/getAll")
    public Response getAll() {
        return jdbi.withHandle(handle -> {
            CarDAO carDao = getAllCars(handle);
            List<Car> cars = carDao.getAll();

            return Response
                    .ok(cars)
                    .build();
        });
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return jdbi.withHandle(handle -> {
            CarDAO carDAO = getById(handle);
            Car car = carDAO.getById(id);

            return Response
                    .ok(car)
                    .build();
        });
    }

    @GET
    @Path("/{limit}/{offset}/{pageID}")
    public Response getCars(@PathParam("limit") int limit, @PathParam("offset") long offset,
            @PathParam("pageID") int pageID) {
        return jdbi.withHandle(handle -> {
            CarDAO carDao = getCarDAO(handle);

            long offsets = limit * (pageID - 1);
            List<Car> cars = carDao.getCars(limit, offsets, pageID);

            return Response
                    .ok(cars)
                    .build();
        });

    }

    @GET
    @Path("/trucks")
    public Response getTrucks() {
        return jdbi.withHandle(handle -> {
            CarDAO carDao = getTrucks(handle);
            List<Car> cars = carDao.getTrucks();

            return Response
                    .ok(cars)
                    .build();
        });

    }

    @GET
    @Path("/suvs")
    public Response getSuvs() {
        return jdbi.withHandle(handle -> {
            CarDAO carDao = getSuvs(handle);
            List<Car> cars = carDao.getSuvs();

            return Response
                    .ok(cars)
                    .build();
        });

    }

    @GET
    @Path("/sedans")
    public Response getSedans() {
        return jdbi.withHandle(handle -> {
            CarDAO carDao = getSedans(handle);
            List<Car> cars = carDao.getSedans();

            return Response
                    .ok(cars)
                    .build();
        });

    }

    CarDAO getAllCars(Handle handle) {
        return new CarDAO(handle);
    }

    CarDAO getById(Handle handle) {
        return new CarDAO(handle);
    }

    CarDAO getCarDAO(Handle handle) {
        return new CarDAO(handle);
    }

    CarDAO getTrucks(Handle handle) {
        return new CarDAO(handle);
    }

    CarDAO getSuvs(Handle handle) {
        return new CarDAO(handle);
    }

    CarDAO getSedans(Handle handle) {
        return new CarDAO(handle);
    }

}
