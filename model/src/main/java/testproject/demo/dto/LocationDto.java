package testproject.demo.dto;

public class LocationDto {
    private String country;
    private String city;
    private String street;
    private String state;
    private String zipcode;

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }
}
