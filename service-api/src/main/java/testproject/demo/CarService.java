package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.CarDto;
import testproject.demo.entities.Car;

import java.util.List;

@Service
public interface CarService {

 Car addCarDTO(CarDto carDto);

 List<CarDto> showAvailableCarsDTO();

 void deleteCarDTO(Long carId);

 Car updateCarDTO(Long carId, CarDto carDto);

 boolean CarIdExists(Long carId);
}
