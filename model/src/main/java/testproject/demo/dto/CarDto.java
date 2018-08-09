package testproject.demo.dto;

import testproject.demo.entities.Car;


public class CarDto {

    private String fuel;
    private String transmission;
    private String brand;
    private String licenseplate;
    private boolean availability;

    public String getFuel() { return fuel; }

    public void setFuel(String fuel) { this.fuel = fuel; }

    public String getTransmission() { return transmission; }

    public void setTransmission(String transmission) { this.transmission = transmission; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public boolean isAvailable() { return availability; }

    public void setAvailability(boolean availability) { this.availability = availability; }

    public String getLicenseplate() { return licenseplate; }

    public void setLicenseplate(String licenseplate) { this.licenseplate = licenseplate; }

}
