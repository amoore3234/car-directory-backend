package io.aimeo.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Jdbi;

import io.aimeo.db.JdbiCarDAO;
import io.aimeo.representations.Car;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private Jdbi jdbi;

    public CarResource(Jdbi jdbi) {
        
    }

    @GET
    @Path("/getAll")
    public Response getAll() {
        JdbiCarDAO cars = new JdbiCarDAO(jdbi);
        List<Car> gCars = cars.getAll();

            return Response
                    .ok(gCars)
                    .build();
        
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        JdbiCarDAO cars = new JdbiCarDAO(jdbi);
            Car carById = cars.getById(id);

            return Response
                    .ok(carById)
                    .build();
        
    }

    @GET
    @Path("/{limit}/{offset}/{pageID}")
    public Response getCars(@PathParam("limit") int limit, @PathParam("offset") long offset,
            @PathParam("pageID") int pageID) {
        JdbiCarDAO jdbiCarDao = new JdbiCarDAO(jdbi);

            long offsets = limit * (pageID - 1);
            List<Car> cars = jdbiCarDao.getCars(limit, offsets, pageID);

            return Response
                    .ok(cars)
                    .build();
    }

    @GET
    @Path("/trucks")
    public Response getTrucks() {
        JdbiCarDAO jdbiCarDao = new JdbiCarDAO(jdbi);
        List<Car> getTrucks = jdbiCarDao.getTrucks();

            return Response
                    .ok(getTrucks)
                    .build();

    }

    @GET
    @Path("/suvs")
    public Response getSuvs() {
        JdbiCarDAO jdbiCarDao = new JdbiCarDAO(jdbi);
            List<Car> getSuvs = jdbiCarDao.getSuvs();

            return Response
                    .ok(getSuvs)
                    .build();

    }

    @GET
    @Path("/sedans")
    public Response getSedans() {
        JdbiCarDAO jdbiCarDao = new JdbiCarDAO(jdbi);
        List<Car> getSuvs = jdbiCarDao.getSedans();

            return Response
                    .ok(getSuvs)
                    .build();

    }


}
