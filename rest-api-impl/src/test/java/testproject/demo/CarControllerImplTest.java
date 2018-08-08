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

    private String transmission = "MANUAL";
    private String fuel = "DIESEL";
    private String brand= "VW GOLF";
    private String licenseplate = "BH01SEA";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showAvailableCars_shouldReturnANonEmptyList()
    {
        List<CarDto> cars = new ArrayList<>();

        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        cars.add(carEntity.toDto());
        when(carServiceMock.showAvailableCarsDTO()).thenReturn(cars);

        ResponseEntity<List<CarDto>> result = carControllerImpl.showAvailableCars();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(cars, result.getBody());
    }

    @Test
    public void addNewCar_ShouldReturnHttpStatusCREATED(){
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        ResponseEntity result = carControllerImpl.addNewCar(carEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(expected, result);
    }

    @Test
    public void deleteCarById_ShouldReturnHttpStatusOK(){

        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setId(5L);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);
        when(carServiceMock.CarIdExists(5L)).thenReturn(true);

        ResponseEntity result = carControllerImpl.deleteCarById(5L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void deleteCarById_ShouldReturnHttpStatusNotFound(){

        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setId(5L);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);
        when(carServiceMock.CarIdExists(5L)).thenReturn(true);


        ResponseEntity result = carControllerImpl.deleteCarById(3L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);
    }

    @Test
    public void updateCar_ShouldReturnHttpStatusOK(){
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setId(5L);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        CarDto carDto = new CarDto();;
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setId(5L);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);
        when(carServiceMock.CarIdExists(5L)).thenReturn(true);

        ResponseEntity result = carControllerImpl.updateCar(5L, carDto);

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);

    }

    @Test
    public void updateCar_ShouldReturnHttpStatusNotFound(){
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setId(5L);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);
        when(carServiceMock.CarIdExists(5L)).thenReturn(true);

        ResponseEntity result = carControllerImpl.updateCar(4L, carEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);

    }
}
