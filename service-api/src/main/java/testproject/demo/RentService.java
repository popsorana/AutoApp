package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.RentDto;
import testproject.demo.entities.Car;
import testproject.demo.entities.Location;
import testproject.demo.entities.Rent;
import testproject.demo.entities.User;

import java.util.List;

@Service
public interface RentService {

    List<RentDto> showAllRentsDTO();

    void createRentDTO(RentDto rentDto);

    User getUserById(Long id);

    Car getCarById(Long id);

    Location getLocationById(Long id);
}
