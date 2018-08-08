package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.UserDto;

@Service
public interface UserService {

    void addUserDTO(UserDto userDto);

    void updateUserDTO(Long userId, UserDto userDto);

    void deleteUserDTO(Long userId);

    boolean UserIdExists(Long userId);
}
