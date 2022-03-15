package io.aimeo;

import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;
import io.dropwizard.util.Resources;

public abstract class AbstractJsonTest {

    protected final ObjectMapper objectMapper = Jackson.newObjectMapper();

    protected String load(String fileName) throws Exception {
        return Resources.toString(Resources.getResource(fileName), StandardCharsets.UTF_8);
    }
}
