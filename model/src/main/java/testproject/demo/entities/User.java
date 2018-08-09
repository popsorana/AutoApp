package testproject.demo.entities;

import testproject.demo.dto.UserDto;
import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int age;
    private String country;
    private String city;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Rent> rents;

    @ManyToOne
    private Role role;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String name) { this.firstName = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setFirstName(this.firstName);
        dto.setLastName(this.lastName);
        dto.setAge(this.age);
        dto.setEmail(this.email);
        dto.setCountry(this.country);
        dto.setCity(this.city);
        dto.setUsername(this.username);
        dto.setPassword(this.password);
        return dto;
    }

    public void Update(UserDto user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.country = user.getCountry();
        this.city = user.getCity();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

}
