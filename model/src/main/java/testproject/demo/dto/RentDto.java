package testproject.demo.dto;

public class RentDto {
    private String startDate;
    private String endDate;
    private int price;
    private Long carId;
    private Long userId;
    private Long locationId;

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public Long getCarId() { return carId; }

    public void setCarId(Long carId) { this.carId = carId; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getLocationId() { return locationId; }

    public void setLocationId(Long locationId) { this.locationId = locationId; }
}
