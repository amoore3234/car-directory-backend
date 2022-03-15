package io.aimeo.representations;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car implements Serializable {
    @JsonProperty("carID")
    private int carID;

    @JsonProperty("categoryID")
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    @ManyToOne(fetch = FetchType.LAZY)
    private int categoryID;

    @JsonProperty("vin")
    private String vin;

    @JsonProperty("carName")
    private String carName;

    @JsonProperty("carModel")
    private String carModel;

    @JsonProperty("carYear")
    private int carYear;

    @JsonProperty("carExterior")
    private String carExterior;

    @JsonProperty("carInterior")
    private String carInterior;

    @JsonProperty("carLocation")
    private String carLocation;

    @JsonProperty("price")
    private int price;

    public Car() {
        this.carID = 0;
        this.categoryID = 0;
        this.vin = null;
        this.carName = null;
        this.carModel = null;
        this.carYear = 0;
        this.carExterior = null;
        this.carInterior = null;
        this.carLocation = null;
        this.price = 0;
    }

    public Car(int carID, int categoryID, String vin, String carName, String carModel, int carYear,
            String carExterior, String carInterior, String carLocation, int price) {
        this.carID = carID;
        this.categoryID = categoryID;
        this.vin = vin;
        this.carName = carName;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carExterior = carExterior;
        this.carInterior = carInterior;
        this.carLocation = carLocation;
        this.price = price;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarExterior() {
        return carExterior;
    }

    public void setCarExterior(String carExterior) {
        this.carExterior = carExterior;
    }

    public String getCarInterior() {
        return carInterior;
    }

    public void setCarInterior(String carInterior) {
        this.carInterior = carInterior;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [carExterior=" + carExterior + ", carID=" + carID + ", carInterior=" + carInterior + ", carModel="
                + carModel + ", carName=" + carName + ", carYear=" + carYear + ", categoryID=" + categoryID + ", price="
                + price + ", vin=" + vin + "]";
    }

}
