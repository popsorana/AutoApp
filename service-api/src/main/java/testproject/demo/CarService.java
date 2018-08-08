package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.CarDto;
import java.util.List;

@Service
public interface CarService {

 void addCarDTO(CarDto carDto);

 List<CarDto> showAvailableCarsDTO();

 void deleteCarDTO(Long carId);

 void updateCarDTO(Long carId, CarDto carDto);

 boolean CarIdExists(Long carId);
}
