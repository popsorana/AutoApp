package testproject.demo;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import testproject.demo.dto.RentDto;
import testproject.demo.entities.Car;
import testproject.demo.entities.Location;
import testproject.demo.entities.Rent;
import testproject.demo.entities.User;
import testproject.demo.repository.CarRepository;
import testproject.demo.repository.LocationRepository;
import testproject.demo.repository.RentRepository;
import testproject.demo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<RentDto> showAllRentsDTO() {
        return rentRepository.findAll()
                .stream()
                .map(Rent::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createRentDTO(RentDto rentDto) {
        Rent rentEntity = new Rent();
        rentEntity.Update(rentDto);
        rentEntity.setUserId(getUserById(rentDto.getUserId()));
        rentEntity.setCarId(getCarById(rentDto.getCarId()));
        rentEntity.setLocationId(getLocationById(rentDto.getLocationId()));
        rentRepository.save(rentEntity);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).get();

    }

}
