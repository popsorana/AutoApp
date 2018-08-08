package testproject.demo.dto;

public class RentDto {
    private String startDate;
    private String endDate;
    private Long price;


    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

}
