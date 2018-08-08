package testproject.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import testproject.demo.dto.UserDto;
import testproject.demo.entities.User;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerImplTest {

    @InjectMocks
    private UserControllerImpl userControllerImpl;

    @Mock
    private UserService userServiceMock;

    private String username = "JohnWest";
    private String password = "pass";
    private String firstName = "John";
    private String lastName = "West";
    private String email = "johnw@gmail.com";
    private int age = 45;
    private String country = "USA";
    private String city = "New York";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewUser_ShouldReturnHttpStatusCREATED(){
        User userEntity = new User();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setAge(age);
        userEntity.setCountry(country);
        userEntity.setCity(city);

        ResponseEntity result = userControllerImpl.addNewUser(userEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(expected, result);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusOK(){
        User userEntity = new User();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setAge(age);
        userEntity.setCountry(country);
        userEntity.setCity(city);
        userEntity.setId(5L);

        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setAge(age);
        userDto.setCountry(country);
        userDto.setCity(city);
        when(userServiceMock.UserIdExists(5L)).thenReturn(true);

        ResponseEntity result = userControllerImpl.updateUser(5L, userDto);

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusNotFound(){
        User userEntity = new User();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setAge(age);
        userEntity.setCountry(country);
        userEntity.setCity(city);
        userEntity.setId(5L);
        when(userServiceMock.UserIdExists(5L)).thenReturn(true);

        ResponseEntity result = userControllerImpl.updateUser(4L, userEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);
    }

    @Test
    public void deleteUserById_ShouldReturnHttpStatusOK(){
        User userEntity = new User();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setAge(age);
        userEntity.setCountry(country);
        userEntity.setCity(city);
        userEntity.setId(5L);
        when(userServiceMock.UserIdExists(5L)).thenReturn(true);

        ResponseEntity result = userControllerImpl.deleteUserById(5L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void deleteUserById_ShouldReturnHttpStatusNotFound(){
        User userEntity = new User();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setAge(age);
        userEntity.setCountry(country);
        userEntity.setCity(city);
        userEntity.setId(5L);
        when(userServiceMock.UserIdExists(5L)).thenReturn(true);

        ResponseEntity result = userControllerImpl.deleteUserById(4L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);

    }
}
