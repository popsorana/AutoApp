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
import testproject.demo.entities.Car;
import testproject.demo.entities.Location;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LocationControllerImplTest {

    @InjectMocks
    private LocationControllerImpl locationControllerImpl;

    @Mock
    private LocationService locationServiceMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewLocation_ShouldReturnHttpStatusCREATED(){
        Location locationEntity = new Location();

        ResponseEntity result = locationControllerImpl.addNewLocation(locationEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(result, expected);
    }

    @Test
    public void addNewLocation_ShouldReturnHttpStatusNotAcceptable(){
        Location locationEntity = new Location();

        ResponseEntity result = locationControllerImpl.addNewLocation(null);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        assertEquals(result, expected);
    }

    @Test
    public void deleteLocationById_ShouldReturnHttpStatusOK(){
        Location locationEntity = new Location();

        when(locationServiceMock.LocationIdExists(locationEntity.getId())).thenReturn(true);

        ResponseEntity result = locationControllerImpl.deleteLocationById(locationEntity.getId());

        ResponseEntity expected = new ResponseEntity(HttpStatus.OK);
        assertEquals(expected, result);
    }

    @Test
    public void deleteLocationById_ShouldReturnHttpStatusNotFound(){
        Location locationEntity = new Location();

        when(locationServiceMock.LocationIdExists(locationEntity.getId())).thenReturn(true);

        ResponseEntity result = locationControllerImpl.deleteLocationById(5L);

        ResponseEntity expected = new ResponseEntity(HttpStatus.NOT_FOUND);
        assertEquals(expected, result);
    }
}
