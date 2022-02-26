package io.aimeo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import ca.grimoire.dropwizard.cors.config.CrossOriginFilterFactory;
import ca.grimoire.dropwizard.cors.config.CrossOriginFilterFactoryHolder;
import io.dropwizard.db.*;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

public class CarDirectoryConfiguration extends Configuration implements CrossOriginFilterFactoryHolder {
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

    @Valid
    @NotNull
    private CrossOriginFilterFactory cors = new CrossOriginFilterFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("jerseyClient")
    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClient;
    }

    @JsonProperty("jerseyClient")
    public void setJerseyClientConfiguration(JerseyClientConfiguration jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public void setCors(CrossOriginFilterFactory cors) {
        this.cors = cors;
    }

    @JsonProperty("cors")
    @Override
    public CrossOriginFilterFactory getCors() {
        return cors;
    } 

}
