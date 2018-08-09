package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.demo.dto.LocationDto;
import testproject.demo.entities.Location;
import testproject.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location addLocationDTO(LocationDto locationDto) {
        Location entity = new Location();
        entity.Update(locationDto);
        return locationRepository.save(entity);
    }

    @Override
    public void deleteLocationDTO(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public boolean LocationIdExists(Long locationId) {
        return locationRepository.findById(locationId).isPresent();
    }
}
