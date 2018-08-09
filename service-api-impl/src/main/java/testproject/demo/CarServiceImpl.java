package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.demo.dto.CarDto;
import testproject.demo.entities.Car;
import testproject.demo.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCarDTO(CarDto carDto) {
        Car entity = new Car();
        carDto.setAvailability(true);
        entity.Update(carDto);
        return carRepository.save(entity);
    }

    @Override
    public List<CarDto> showAvailableCarsDTO() {
        return carRepository.findAll()
                .stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCarDTO(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public Car updateCarDTO(Long carId, CarDto carDto) {
        Car entity = carRepository.findById(carId).get();
        entity.Update(carDto);
        return carRepository.save(entity);
    }

    @Override
    public boolean CarIdExists(Long carId) {
        return carRepository.findById(carId).isPresent();
    }
}
