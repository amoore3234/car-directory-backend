package io.aimeo.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.aimeo.db.CarDAO;
import io.aimeo.representations.Car;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private final CarDAO carDAO;

    public CarResource(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GET
    @Path("/getAll")
    public Response getAll() {
        List<Car> gCars = carDAO.getAll();

            return Response
                    .ok(gCars)
                    .build();
        
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
            Car carById = carDAO.getById(id);

            return Response
                    .ok(carById)
                    .build();
        
    }

    @GET
    @Path("/{limit}/{offset}/{pageID}")
    public Response getCars(@PathParam("limit") int limit, @PathParam("offset") long offset,
            @PathParam("pageID") int pageID) {

            long offsets = limit * (pageID - 1);
            List<Car> cars = carDAO.getCars(limit, offsets, pageID);

            return Response
                    .ok(cars)
                    .build();
    }

    @GET
    @Path("/trucks")
    public Response getTrucks() {
        List<Car> getTrucks = carDAO.getTrucks();

            return Response
                    .ok(getTrucks)
                    .build();

    }

    @GET
    @Path("/suvs")
    public Response getSuvs() {
            List<Car> getSuvs = carDAO.getSuvs();

            return Response
                    .ok(getSuvs)
                    .build();

    }

    @GET
    @Path("/sedans")
    public Response getSedans() {
        List<Car> getSuvs = carDAO.getSedans();

            return Response
                    .ok(getSuvs)
                    .build();

    }


}
