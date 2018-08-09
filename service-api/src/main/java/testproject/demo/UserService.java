package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.UserDto;
import testproject.demo.entities.User;

@Service
public interface UserService {

    User addUserDTO(UserDto userDto);

    User updateUserDTO(Long userId, UserDto userDto);

    void deleteUserDTO(Long userId);

    boolean UserIdExists(Long userId);
}
