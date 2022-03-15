package io.aimeo.api;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.aimeo.AbstractJsonTest;
import io.aimeo.representations.Car;

public class CarTest extends AbstractJsonTest {
    
   @Test
   void serializeTest() throws Exception {
       Car car = new Car();
       car.setCarID(1);
       car.setCategoryID(1);
       car.setVin("1GCHSBEN4N1113156");
       car.setCarName("Colorado");
       car.setCarModel("Chevrolet");
       car.setCarYear(2022);
       car.setCarExterior("Bright Blue Metallic");
       car.setCarInterior("Single-zone climate control, 6-speaker audio system");
       car.setCarLocation("MOUNTAIN VIEW CHEVROLET, INC.");
       car.setPrice(29985);

       String expected = load("fixtures/car.json");
       assertThatJson(expected).isEqualTo(objectMapper.writeValueAsString(car));
   }

   @Test
   void deserializeTest() throws Exception {
       String json = load("fixtures/car.json");
       Car car = objectMapper.readValue(json, Car.class);

       assertThat(car.getCarID()).isEqualTo(1);
       assertThat(car.getCategoryID()).isEqualTo(1);
       assertThat(car.getVin()).isEqualTo("1GCHSBEN4N1113156");
       assertThat(car.getCarName()).isEqualTo("Colorado");
       assertThat(car.getCarModel()).isEqualTo("Chevrolet");
       assertThat(car.getCarYear()).isEqualTo(2022);
       assertThat(car.getCarExterior()).isEqualTo("Bright Blue Metallic");
       assertThat(car.getCarInterior()).isEqualTo("Single-zone climate control, 6-speaker audio system");
       assertThat(car.getCarLocation()).isEqualTo("MOUNTAIN VIEW CHEVROLET, INC.");
       assertThat(car.getPrice()).isEqualTo(29985);
   }

}
