package testproject.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import testproject.demo.dto.CarDto;
import testproject.demo.entities.Car;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CarControllerImplTest {

    @InjectMocks
    private CarControllerImpl carControllerImpl;

    @Mock
    private CarService carServiceMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showAvailableCars_shouldReturnANonEmptyList() {
        List<CarDto> cars = new ArrayList<>();

        Car carEntity = new Car();

        cars.add(carEntity.toDto());
        when(carServiceMock.showAvailableCarsDTO()).thenReturn(cars);

        ResponseEntity<List<CarDto>> result = carControllerImpl.showAvailableCars();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(cars, result.getBody());
    }

    @Test
    public void addNewCar_ShouldReturnHttpStatusCREATED() {
        Car carEntity = new Car();

        ResponseEntity result = carControllerImpl.addNewCar(carEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(expected, result);
    }

    @Test
    public void addNewCar_ShouldReturnHttpStatusNotAcceptable() {
        Car carEntity = new Car();

        ResponseEntity result = carControllerImpl.addNewCar(null);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        assertEquals(expected, result);
    }

    @Test
    public void deleteCarById_ShouldReturnHttpStatusOK() {

        Car carEntity = new Car();

        when(carServiceMock.CarIdExists(carEntity.getId())).thenReturn(true);

        ResponseEntity result = carControllerImpl.deleteCarById(carEntity.getId());

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void deleteCarById_ShouldReturnHttpStatusNotFound() {

        Car carEntity = new Car();

        when(carServiceMock.CarIdExists(carEntity.getId())).thenReturn(true);


        ResponseEntity result = carControllerImpl.deleteCarById(3L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);
    }

    @Test
    public void updateCar_ShouldReturnHttpStatusOK() {
        Car carEntity = new Car();


        CarDto carDto = new CarDto();

        when(carServiceMock.CarIdExists(carEntity.getId())).thenReturn(true);

        ResponseEntity result = carControllerImpl.updateCar(carEntity.getId(), carDto);

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);

    }

    @Test
    public void updateCar_ShouldReturnHttpStatusNotFound() {
        Car carEntity = new Car();

        CarDto carDto = new CarDto();


        ResponseEntity result = carControllerImpl.updateCar(carEntity.getId(), carDto);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);

    }
}
