package play.with.springboot.service;

import org.springframework.stereotype.Service;
import play.with.springboot.exception.BagNotFoundException;
import play.with.springboot.model.Bag;
import play.with.springboot.repository.BagRepository;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class BagService {
    private final BagRepository bagRepository;

    public BagService(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    public int save(Bag bag) {
        final int id = bagRepository.findAll().size() + 1;
        bag.setId(id);
        Bag savedBag = bagRepository.save(bag);
        return savedBag.getId();
    }

    public void update(Bag bag) {
        Bag existingBag = bagRepository.findOne(bag.getId());
        if (nonNull(existingBag)) {
            updateBag(bag, existingBag);
        } else {
            throw new BagNotFoundException();
        }
    }

    private void updateBag(Bag bag, Bag existingBag) {
        existingBag.setCapacity(bag.getCapacity());
        existingBag.setType(bag.getType());
        bagRepository.save(existingBag);
    }

    public List<Bag> getBags() {
        return bagRepository.findAll();
    }
}
