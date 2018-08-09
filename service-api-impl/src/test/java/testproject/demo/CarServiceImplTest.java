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

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCarDTO_ShouldReturnASavedCarDTO() {
        Car carEntity = new Car();

        Car result = carServiceImpl.addCarDTO(carEntity.toDto());

        Car expected = carRepositoryMock.save(carEntity);
        assertEquals(result, expected);
    }

    @Test
    public void showAllAvailableCarsDTO_ShouldReturnANonEmptyList() {
        Car carEntity_1 = new Car();

        Car carEntity_2 = new Car();

        List<Car> carEntities = Arrays.asList(carEntity_1, carEntity_2);
        when(carRepositoryMock.findAll()).thenReturn(carEntities);

        List<CarDto> result = carServiceImpl.showAvailableCarsDTO();

        assertEquals(2, result.size());

    }

    @Test
    public void deleteCarDTO_ShouldVerifyIfCalled() {
        Car carEntity = new Car();

        carRepositoryMock.findById(carEntity.getId());

        carServiceImpl.deleteCarDTO(carEntity.getId());

        verify(carRepositoryMock).deleteById(carEntity.getId());
    }

    @Test
    public void updateCarDTO_ShouldVerifyIfCalled() {
        Car carEntity = new Car();

        CarDto carDto = new CarDto();

        when(carRepositoryMock.findById(carEntity.getId())).thenReturn(Optional.of(carEntity));
        Car result = carServiceImpl.updateCarDTO(carEntity.getId(), carDto);

        Car expected = carRepositoryMock.save(carEntity);

        assertEquals(result, expected);
    }

    @Test
    public void CarIdExists_ShouldReturnTrue() {
        Car carEntity = new Car();

        boolean result = carServiceImpl.CarIdExists(carEntity.getId());

        boolean expected = carRepositoryMock.findById(carEntity.getId()).isPresent();

        assertEquals(expected, result);
    }
}
