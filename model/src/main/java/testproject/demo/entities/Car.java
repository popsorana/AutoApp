package testproject.demo.entities;

import testproject.demo.dto.CarDto;
import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String licenseplate;
    private String fuel;
    private String transmission;
    private String brand;
    private boolean availability;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getLicenseplate() { return licenseplate; }

    public void setLicenseplate(String licenseplate) { this.licenseplate = licenseplate; }

    public String getFuel() { return fuel; }

    public void setFuel(String fuel) { this.fuel = fuel; }

    public String getTransmission() { return transmission; }

    public void setTransmission(String transmission) { this.transmission = transmission; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public boolean isAvailable() { return availability; }

    public void setAvailability(boolean availability) { this.availability = availability; }

    public CarDto toDto() {
        CarDto dto = new CarDto();
        dto.setBrand(this.brand);
        dto.setAvailability(this.availability);
        dto.setFuel(this.fuel);
        dto.setTransmission(this.transmission);
        dto.setLicenseplate(this.licenseplate);
        return dto;
    }

    public void Update(CarDto car) {
        this.brand = car.getBrand();
        this.fuel = car.getFuel();
        this.transmission = car.getTransmission();
        this.availability = car.isAvailable();
        this.licenseplate = car.getLicenseplate();
    }


}
