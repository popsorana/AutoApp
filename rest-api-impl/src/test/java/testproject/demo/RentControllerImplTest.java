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
import testproject.demo.dto.RentDto;
import testproject.demo.entities.Rent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RentControllerImplTest {

    @InjectMocks
    private RentControllerImpl rentControllerImpl;

    @Mock
    private RentService rentServiceMock;

    private String startDate = "29/08/2018";
    private String endDate = "5/09/2018";
    private long price = 5000;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showAllRents_ShouldReturnANonEmptyList() {
        List<RentDto> rents = new ArrayList<>();

        Rent rentEntity = new Rent();
        rentEntity.setStartDate(startDate);
        rentEntity.setEndDate(endDate);
        rentEntity.setPrice(price);

        rents.add(rentEntity.toDto());
        when(rentServiceMock.showAllRentsDTO()).thenReturn(rents);

        ResponseEntity<List<RentDto>> result = rentControllerImpl.showAllRents();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(rents);
    }

    @Test
    public void showAllRents_ShouldReturnAnEmptyList() {
        ResponseEntity<List<RentDto>> result = rentControllerImpl.showAllRents();

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    @Test
    public void rentACar_ShouldReturnHttpStatusCREATED() {
        Rent rentEntity = new Rent();
        rentEntity.setPrice(price);
        rentEntity.setStartDate(startDate);
        rentEntity.setEndDate(endDate);

        ResponseEntity result = rentControllerImpl.rentACar(rentEntity.toDto());

        ResponseEntity expected = new ResponseEntity(HttpStatus.CREATED);
        assertEquals(expected, result);
    }
}
