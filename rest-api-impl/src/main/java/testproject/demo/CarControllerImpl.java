package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testproject.demo.dto.CarDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin
@RestController
public class CarControllerImpl implements CarController {

    @Autowired
    CarService carService;

    @GetMapping("/available")
    public ResponseEntity<List<CarDto>> showAvailableCars() {
        return new ResponseEntity<>(carService.showAvailableCarsDTO(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity addNewCar(@RequestBody CarDto carDto) {
        if (carDto != null) {
            carService.addCarDTO(carDto);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/delete/{carId}")
    public ResponseEntity<CarDto> deleteCarById(@PathVariable("carId") Long carId) {
        if (carService.CarIdExists(carId)) {
            carService.deleteCarDTO(carId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/edit/{carId}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long carId, @RequestBody CarDto carDto) {
        if (carService.CarIdExists(carId)) {
            carService.updateCarDTO(carId, carDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
