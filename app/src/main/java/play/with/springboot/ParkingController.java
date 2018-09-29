package play.with.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import play.with.springboot.model.Parking;
import play.with.springboot.repository.ParkingRepository;

import java.util.List;

@RestController
public class ParkingController {

    private final ParkingRepository parkingRepository;

    public ParkingController(@Autowired ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @GetMapping("/parkings")
    public List<Parking> getParkings(){
        return parkingRepository.findAll();
    }
}