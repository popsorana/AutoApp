package testproject.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import testproject.demo.entities.Location;
import testproject.demo.repository.LocationRepository;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LocationServiceImplTest {

    @InjectMocks
    private LocationServiceImpl locationServiceImpl;

    @Mock
    private LocationRepository locationRepositoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addLocationDTO_ShouldReturnASavedLocationDTO() {
        Location locationEntity = new Location();

        Location result = locationServiceImpl.addLocationDTO(locationEntity.toDto());

        Location expected = locationRepositoryMock.save(locationEntity);
        assertEquals(result, expected);
    }

    @Test
    public void deleteLocationDTO_ShouldVerifyIfCalled() {
        Location locationEntity = new Location();

        locationRepositoryMock.findById(locationEntity.getId());

        locationServiceImpl.deleteLocationDTO(locationEntity.getId());

        verify(locationRepositoryMock).deleteById(locationEntity.getId());
    }

    @Test
    public void LocationIdExists_ShouldReturnTrue() {
        Location locationEntity = new Location();

        boolean result = locationServiceImpl.LocationIdExists(locationEntity.getId());

        boolean expected = locationRepositoryMock.findById(locationEntity.getId()).isPresent();

        assertEquals(expected, result);
    }
}
