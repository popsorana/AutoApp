package testproject.demo.entities;

import testproject.demo.dto.RentDto;
import javax.persistence.*;

@Entity
@Table(name="rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Car carId;

    @ManyToOne
    private User userId;

    private String startDate;
    private String endDate;
    private long price;

    @ManyToOne
    private Location locationId;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Car getCarId() { return carId; }

    public void setCarId(Car carId) { this.carId = carId; }

    public User getUserId() { return userId; }

    public void setUserId(User userId) { this.userId = userId; }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public long getPrice() { return price; }

    public void setPrice(long price) { this.price = price; }

    public Location getLocationId() { return locationId; }

    public void setLocationId(Location locationId) { this.locationId = locationId; }

    public RentDto toDto() {
        RentDto dto = new RentDto();
        dto.setStartDate(this.startDate);
        dto.setEndDate(this.endDate);
        dto.setPrice(this.price);
        return dto;
    }

    public void Update(RentDto rent) {
        this.startDate = rent.getStartDate();
        this.endDate = rent.getEndDate();
        this.price = rent.getPrice();
    }
}
