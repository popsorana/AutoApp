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


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewUser_ShouldReturnHttpStatusCREATED() {
        User userEntity = new User();

        ResponseEntity result = userControllerImpl.addNewUser(userEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(expected, result);
    }

    @Test
    public void addNewUser_ShouldReturnHttpStatusNotAcceptable() {
        User userEntity = new User();

        ResponseEntity result = userControllerImpl.addNewUser(null);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        assertEquals(expected, result);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusOK() {
        User userEntity = new User();

        UserDto userDto = new UserDto();

        when(userServiceMock.UserIdExists(userEntity.getId())).thenReturn(true);

        ResponseEntity result = userControllerImpl.updateUser(userEntity.getId(), userDto);

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void updateUser_ShouldReturnHttpStatusNotFound() {
        User userEntity = new User();

        when(userServiceMock.UserIdExists(userEntity.getId())).thenReturn(true);

        ResponseEntity result = userControllerImpl.updateUser(4L, userEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);
    }

    @Test
    public void deleteUserById_ShouldReturnHttpStatusOK() {
        User userEntity = new User();

        when(userServiceMock.UserIdExists(userEntity.getId())).thenReturn(true);

        ResponseEntity result = userControllerImpl.deleteUserById(userEntity.getId());

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void deleteUserById_ShouldReturnHttpStatusNotFound() {
        User userEntity = new User();

        when(userServiceMock.UserIdExists(userEntity.getId())).thenReturn(true);

        ResponseEntity result = userControllerImpl.deleteUserById(4L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);

    }
}
