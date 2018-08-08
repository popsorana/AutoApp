package testproject.demo;

import testproject.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public interface UserController {

    @PostMapping("/add")
    ResponseEntity addNewUser(@RequestBody UserDto userDto);

    @PutMapping("/edit/{userId}")
    ResponseEntity updateUser(@PathVariable Long userId, @RequestBody UserDto userDto);

    @DeleteMapping("/delete/{userId}")
    ResponseEntity deleteUserById(@PathVariable Long userId);

}
