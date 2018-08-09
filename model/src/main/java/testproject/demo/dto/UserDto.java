package testproject.demo.dto;

public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String country;
    private String city;
    private String role;


    public void setUsername(String username){ this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
