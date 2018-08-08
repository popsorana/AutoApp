package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testproject.demo.dto.RentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin
@RestController
public class RentControllerImpl implements RentController {

    @Autowired
    RentService rentService;

    @GetMapping("/show/allRents")
    public ResponseEntity<List<RentDto>> showAllRents() {
        List<RentDto> rents = rentService.showAllRentsDTO();
        if (rents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createRent")
    public ResponseEntity rentACar(@RequestBody RentDto rentDto) {
        rentService.createRentDTO(rentDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
