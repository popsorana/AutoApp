package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.demo.dto.UserDto;
import testproject.demo.entities.User;
import testproject.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUserDTO(UserDto userDto) {
        User entity = new User();
        entity.Update(userDto);
        return userRepository.save(entity);
    }

    @Override
    public User updateUserDTO(Long userId, UserDto userDto) {
        User entity = userRepository.findById(userId).get();
        entity.Update(userDto);
        return userRepository.save(entity);
    }

    @Override
    public void deleteUserDTO(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean UserIdExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }

}
