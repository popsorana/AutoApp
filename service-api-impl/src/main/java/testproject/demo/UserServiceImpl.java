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
    public void addUserDTO(UserDto userDto) {
        User entity = new User();
        entity.Update(userDto);
        userRepository.save(entity);
    }

    @Override
    public void updateUserDTO(Long userId, UserDto userDto) {
        userRepository.findById(userId);
        User entity = new User();
        entity.Update(userDto);
        userRepository.save(entity);
    }

    @Override
    public void deleteUserDTO(Long userId) {
        userRepository.findAll().forEach(user -> {
            userRepository.deleteById(userId);
        });
    }

    @Override
    public boolean UserIdExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }

}
