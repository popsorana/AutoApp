package testproject.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import testproject.demo.dto.RentDto;
import testproject.demo.entities.Rent;
import testproject.demo.repository.RentRepository;

import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RentServiceImplTest {

    @InjectMocks
    private RentServiceImpl rentServiceImpl;

    @Mock
    private RentRepository rentRepositoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showAllRentsDTO_ShouldReturnANonEmptyList() {
        Rent rentEntity = new Rent();
        List<Rent> rentEntities = Collections.singletonList(rentEntity);
        when(rentRepositoryMock.findAll()).thenReturn(rentEntities);

        List<RentDto> result = rentServiceImpl.showAllRentsDTO();
        assertEquals(1, result.size());
    }

//    @Test
//    public void createRentDTO_ShouldReturnASavedRentDTO() {
//        Rent rentEntity = new Rent();
//
//        Rent result = rentServiceImpl.createRentDTO(rentEntity.toDto());
//
//        Rent expected = rentRepositoryMock.save(rentEntity);
//        assertEquals(result, expected);
//    }
}

