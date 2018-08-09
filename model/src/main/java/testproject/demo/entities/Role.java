package testproject.demo.entities;

import testproject.demo.dto.RoleDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> users;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public List<User> getUsers() { return users; }

    public void setUsers(List<User> users) { this.users = users; }

    public RoleDto toDto(){
        RoleDto dto = new RoleDto();
        dto.setRole(this.role);
        return dto;
    }
}
