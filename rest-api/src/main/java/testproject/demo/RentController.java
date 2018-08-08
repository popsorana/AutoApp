package testproject.demo;

import testproject.demo.dto.RentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rents")
public interface RentController {

    @GetMapping("/show/allRents")
    ResponseEntity<List<RentDto>> showAllRents();

    @PostMapping("/createRent")
    ResponseEntity rentACar(@RequestBody RentDto rentDto);
}
