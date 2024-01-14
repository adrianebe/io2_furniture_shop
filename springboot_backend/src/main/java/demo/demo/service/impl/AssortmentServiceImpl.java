package demo.demo.service.impl;

import demo.demo.entity.Assortment;
import demo.demo.exception.AssortmentNotFoundException;
import demo.demo.repository.AssortmentRepo;
import demo.demo.service.AssortmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class AssortmentServiceImpl implements AssortmentService {

    private final AssortmentRepo assortmentRepo;

    @Override
    public List<Assortment> getAllAssortments() {
        return assortmentRepo.findAll();
    }

    @Override
    public Assortment getAssortmentById(Long assortmentId) {
        return assortmentRepo.findById(assortmentId)
                .orElseThrow(() -> new AssortmentNotFoundException("Assortment with Id " + assortmentId + " not found"));
    }

    @Override
    public List<Assortment> getAllAssortmentsByRoomType(String roomType) {
        return assortmentRepo.findAllByRoomType(roomType);
    }

    @Override
    public Assortment getAssortmentByIdAndRoomType(String roomType, Long assortmentId) {
        return assortmentRepo.findOneByIdAndRoomType(assortmentId, roomType);
    }

    @Override
    public Assortment addNewAssortment(Assortment assortment) {
        return assortmentRepo.save(assortment);
    }

    @Override
    public Assortment updateAssortment(Long assortmentId, Assortment updatedAssortment) {
        Optional<Assortment> existingAssortmentOptional = assortmentRepo.findById(assortmentId);

        if (existingAssortmentOptional.isPresent()) {
            Assortment existingAssortment = existingAssortmentOptional.get();

            if (updatedAssortment.getName() != null) {
                existingAssortment.setName(updatedAssortment.getName());
            }

            if (updatedAssortment.getRoomType() != null) {
                existingAssortment.setRoomType(updatedAssortment.getRoomType());
            }

            if (updatedAssortment.getPrice() != 0) {
                existingAssortment.setPrice(updatedAssortment.getPrice());
            }

            if (updatedAssortment.getDescription() != null) {
                existingAssortment.setDescription(updatedAssortment.getDescription());
            }

            if (updatedAssortment.getAvailability() != 0) {
                existingAssortment.setAvailability(updatedAssortment.getAvailability());
            }
            return assortmentRepo.save(existingAssortment);

        } else {
            throw new AssortmentNotFoundException("Assortment with Id " + assortmentId + " not found");
        }
    }

    @Override
    public void deleteAssortment(Long id) {
        assortmentRepo.deleteById(id);
    }
}
