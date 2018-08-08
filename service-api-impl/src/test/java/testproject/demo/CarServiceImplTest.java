package testproject.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import testproject.demo.dto.CarDto;
import testproject.demo.entities.Car;
import testproject.demo.repository.CarRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carServiceImpl;

    @Mock
    private CarRepository carRepositoryMock;

    private String transmission = "MANUAL";
    private String fuel = "DIESEL";
    private String brand = "VW GOLF";
    private String licenseplate = "BH01SEA";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCarDTO_ShouldReturnHttpStatusOK() {
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        Car result = carServiceImpl.addCarDTO(carEntity.toDto());

        Car expected = carRepositoryMock.save(carEntity);
        assertEquals(result, expected);
    }

    @Test
    public void showAllAvailableCarsDTO_ShouldReturnANonEmptyList() {
        Car carEntity_1 = new Car();
        carEntity_1.setBrand(brand);
        carEntity_1.setFuel(fuel);
        carEntity_1.setTransmission(transmission);
        carEntity_1.setLicenseplate(licenseplate);

        Car carEntity_2 = new Car();
        carEntity_2.setBrand("AUDI");
        carEntity_2.setFuel("PETROL");
        carEntity_2.setTransmission("MANUAL");
        carEntity_2.setLicenseplate("BH87FJS");
        List<Car> carEntities = Arrays.asList(carEntity_1, carEntity_2);
        when(carRepositoryMock.findAll()).thenReturn(carEntities);

        List<CarDto> result = carServiceImpl.showAvailableCarsDTO();

        assertEquals(2, result.size());

        CarDto expected_1 = result.get(0);
        CarDto expected_2 = result.get(1);

        assertEquals(brand, expected_1.getBrand());
        assertEquals("AUDI", expected_2.getBrand());
    }

    @Test
    public void deleteCarDTO_ShouldVerifyIfCalled() {
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        carRepositoryMock.findById(carEntity.getId());

        carServiceImpl.deleteCarDTO(carEntity.getId());

        verify(carRepositoryMock).deleteById(carEntity.getId());
    }

    @Test
    public void updateCarDTO_ShouldVerifyIfCalled() {
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        CarDto carDto = new CarDto();
        carDto.setBrand("AUDI");
        carDto.setFuel("PETROL");
        carDto.setLicenseplate("BH73IMF");
        carDto.setTransmission("MANUAL");
        when(carRepositoryMock.findById(carEntity.getId())).thenReturn(Optional.of(carEntity));
        Car result = carServiceImpl.updateCarDTO(carEntity.getId(), carDto);

        Car expected = carRepositoryMock.save(carEntity);

        assertEquals(result, expected);
    }

    @Test
    public void CarIdExists_ShouldReturnTrue() {
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setFuel(fuel);
        carEntity.setTransmission(transmission);
        carEntity.setLicenseplate(licenseplate);

        boolean result = carServiceImpl.CarIdExists(carEntity.getId());

        boolean expected = carRepositoryMock.findById(carEntity.getId()).isPresent();

        assertEquals(expected, result);
    }
}
