package demo.demo.service.impl;

import demo.demo.entity.Assortment;
import demo.demo.exception.custom.AssortmentNotFoundException;
import demo.demo.repository.AssortmentRepo;
import demo.demo.service.AssortmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
    public Assortment getAssortmentByIdAndRoomType(Long assortmentId, String roomType) {
        return assortmentRepo.findOneByIdAndRoomType(assortmentId, roomType);
    }

    @Override
    public void createNewAssortment(Assortment assortment) {
        assortmentRepo.save(assortment);
    }

    @Override
    public void updateAssortment(Long assortmentId, Assortment updatedAssortment) {
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

            if (updatedAssortment.getPhoto() != null) {
                existingAssortment.setPhoto(updatedAssortment.getPhoto());
            }

            if (updatedAssortment.getAvailability() != 0) {
                existingAssortment.setAvailability(updatedAssortment.getAvailability());
            }
            assortmentRepo.save(existingAssortment);

        } else {
            throw new AssortmentNotFoundException("Assortment with Id " + assortmentId + " not found");
        }
    }

    @Override
    public void deleteAssortment(Long assortmentId) {
        assortmentRepo.deleteById(assortmentId);
    }

    @Override
    public boolean isAssortmentAvailable(Assortment assortment) {
        Optional<Assortment> optionalAssortment = assortmentRepo.findById(assortment.getId());

        if (optionalAssortment.isPresent()) {
            Assortment dbAssortment = optionalAssortment.get();

            return dbAssortment.getAvailability() == 1;
        } else {
            throw new AssortmentNotFoundException("Assortment by id: " + assortment.getId() + " was not found!");
        }
    }

}
