package testproject.demo.entities;

import testproject.demo.dto.RentDto;
import javax.persistence.*;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "car_id_id")
    private Car carId;

    @ManyToOne()
    @JoinColumn(name = "user_id_id")
    private User userId;

    private String startDate;
    private String endDate;
    private int price;

    @ManyToOne()
    @JoinColumn(name = "location_id_id")
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

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

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
