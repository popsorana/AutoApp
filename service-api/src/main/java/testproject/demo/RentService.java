package testproject.demo;

import org.springframework.stereotype.Service;
import testproject.demo.dto.RentDto;
import java.util.List;

@Service
public interface RentService {

    List<RentDto> showAllRentsDTO();

    void createRentDTO(RentDto rentDto);
}
