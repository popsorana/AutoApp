package testproject.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testproject.demo.dto.LocationDto;

@RestController
@RequestMapping(path = "/locations")
public interface LocationController {

    @PostMapping("/add")
    ResponseEntity addNewLocation(@RequestBody LocationDto locationDto);

    @DeleteMapping("/delete/{locationId}")
    ResponseEntity deleteLocationById(@PathVariable Long locationId);

}
