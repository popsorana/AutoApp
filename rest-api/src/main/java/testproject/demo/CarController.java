package testproject.demo;

import testproject.demo.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public interface CarController {

    @GetMapping("/available")
    ResponseEntity<List<CarDto>> showAvailableCars();

    @PostMapping("/add")
    ResponseEntity addNewCar(@RequestBody CarDto carDto);

    @DeleteMapping("/delete/{carId}")
    ResponseEntity deleteCarById(@PathVariable Long carId);

    @PutMapping("/edit/{carId}")
    ResponseEntity updateCar(@PathVariable Long carId, @RequestBody CarDto carDto);
}
