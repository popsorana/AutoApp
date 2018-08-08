package testproject.demo.entities;

import testproject.demo.dto.LocationDto;

import javax.persistence.*;

@Entity
@Table(name="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String country;
    private String street;
    private String zipcode;
    private String city;
    private String state;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public LocationDto toDto() {
        LocationDto dto = new LocationDto();
        dto.setCountry(this.country);
        dto.setCity(this.city);
        dto.setStreet(this.street);
        dto.setZipcode(this.zipcode);
        dto.setState(this.state);
        return dto;
    }

    public void Update(LocationDto location){
        this.country = location.getCountry();
        this.city = location.getCity();
        this.street = location.getStreet();
        this.zipcode = location.getZipcode();
        this.state = location.getState();
    }
}
