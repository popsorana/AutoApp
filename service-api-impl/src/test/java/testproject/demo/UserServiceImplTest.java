package testproject.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import testproject.demo.dto.UserDto;
import testproject.demo.entities.User;
import testproject.demo.repository.UserRepository;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepositoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addUserDTO_ShouldReturnASavedUserDTO() {
        User userEntity = new User();

        User result = userServiceImpl.addUserDTO(userEntity.toDto());

        User expected = userRepositoryMock.save(userEntity);
        assertEquals(result, expected);
    }

    @Test
    public void updateUserDTO_ShouldVerifyIfCalled() {
        User userEntity = new User();

        UserDto userDto = new UserDto();

        when(userRepositoryMock.findById(userEntity.getId())).thenReturn(Optional.of(userEntity));
        User result = userServiceImpl.updateUserDTO(userEntity.getId(), userDto);

        User expected = userRepositoryMock.save(userEntity);

        assertEquals(result, expected);
    }

    @Test
    public void deleteUserDTO_ShouldVerifyIfCalled(){
        User userEntity = new User();

        userRepositoryMock.findById(userEntity.getId());

        userServiceImpl.deleteUserDTO(userEntity.getId());

        verify(userRepositoryMock).deleteById(userEntity.getId());
    }

    @Test
    public void UserIdExists_ShouldReturnTrue(){
        User userEntity = new User();

        boolean result = userServiceImpl.UserIdExists(userEntity.getId());

        boolean expected = userRepositoryMock.findById(userEntity.getId()).isPresent();

        assertEquals(result, expected);
    }

}
