package io.aimeo;

import javax.ws.rs.client.Client;
import org.jdbi.v3.core.Jdbi;

import ca.grimoire.dropwizard.cors.CorsBundle;
import io.aimeo.Mappers.CarMapper;
import io.aimeo.db.JdbiCarDAO;
import io.aimeo.representations.Car;
import io.aimeo.resources.CarResource;
import io.aimeo.resources.ClientResource;
import io.aimeo.resources.CustomerResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CarDirectoryApplication extends Application<CarDirectoryConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CarDirectoryApplication().run(args);
    }

    @Override
    public String getName() {
        return "CarDirectory";
    }

    @Override
    public void initialize(final Bootstrap<CarDirectoryConfiguration> bootstrap) {
        bootstrap.addBundle(new CorsBundle<CarDirectoryConfiguration>());
    }

    @Override
    public void run(final CarDirectoryConfiguration configuration,
            final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build(getName());

        jdbi.registerRowMapper(Car.class, new CarMapper());
        environment.jersey().register(new JsonProcessingExceptionMapper(true));

        environment.jersey().register(new CustomerResource(jdbi, environment.getValidator()));
        environment.jersey().register(new CarResource(new JdbiCarDAO(jdbi)));
        environment.jersey().register(new ClientResource(client));

    }

}
