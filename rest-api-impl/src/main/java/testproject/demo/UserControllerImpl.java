package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testproject.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;

@CrossOrigin
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addNewUser(@RequestBody UserDto userDto) {
            userService.addUserDTO(userDto);
            return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{userId}")
    public ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        if (userService.UserIdExists(userId)) {
            userService.updateUserDTO(userId, userDto);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUserById(@PathVariable Long userId) {
        if (userService.UserIdExists(userId)) {
            userService.deleteUserDTO(userId);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
