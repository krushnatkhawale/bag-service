package play.with.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import play.with.springboot.model.Bag;
import play.with.springboot.repository.BagRepository;
import play.with.springboot.service.BagService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class BagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BagController.class);

    private BagService bagService;

    public BagController(@Autowired BagService bagService) {
        this.bagService = bagService;
    }

    @ApiOperation(value = "Get list of bags", response = ResponseEntity.class)
    @GetMapping("/bags")
    public List<Bag> getBags() {
        LOGGER.info("getBags called");
        return bagService.getBags();
    }

    @ApiOperation(value = "Create a new bag", response = ResponseEntity.class)
    @PostMapping("/bags")
    public ResponseEntity<Integer> saveBag(@RequestBody Bag bag) {
        LOGGER.info("saveBag: " + bag);
        int id = bagService.save(bag);
        return new ResponseEntity<>(id, OK);
    }

    @ApiOperation(value = "Update an existing bag", response = ResponseEntity.class)
    @PutMapping("/bags")
    public ResponseEntity<Integer> updateBag(@RequestBody Bag bag) {
        LOGGER.info("updateBag: " + bag);
        bagService.update(bag);
        return new ResponseEntity<>(OK);
    }
}