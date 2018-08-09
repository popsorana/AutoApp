package testproject.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testproject.demo.dto.LocationDto;

@CrossOrigin
@RestController
public class LocationControllerImpl implements LocationController{

    @Autowired
    LocationService locationService;

    @PostMapping("/add")
    public ResponseEntity addNewLocation(@RequestBody LocationDto locationDto) {
         if(locationDto != null)
         {
             locationService.addLocationDTO(locationDto);
             return new ResponseEntity(HttpStatus.CREATED);
         }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity deleteLocationById(@PathVariable("locationId") Long locationId) {
        if (locationService.LocationIdExists(locationId)) {
            locationService.deleteLocationDTO(locationId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
