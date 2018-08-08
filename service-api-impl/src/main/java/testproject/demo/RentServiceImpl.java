package testproject.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.demo.dto.RentDto;
import testproject.demo.entities.Rent;
import testproject.demo.repository.RentRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService{

    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<RentDto> showAllRentsDTO() {
        return rentRepository.findAll()
                .stream()
                .map(Rent::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createRentDTO(RentDto rentDto) {
        Rent entity = new Rent();
        entity.Update(rentDto);
        rentRepository.save(entity);
    }
}
