package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.LocationDto;
import testproject.demo.entities.Location;

@Service
public interface LocationService {
    Location addLocationDTO(LocationDto locationDto);

    void deleteLocationDTO(Long locationId);

    boolean LocationIdExists(Long locationId);
}
