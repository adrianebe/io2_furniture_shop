package demo.demo.service.impl;

import demo.demo.entity.Assortment;
import demo.demo.repository.AssortmentRepo;
import demo.demo.service.AssortmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AssortmentServiceImpl implements AssortmentService {

    private final AssortmentRepo assortmentRepo;

    @Override
    public List<Assortment> getAllAssortments() {
        return assortmentRepo.findAll();
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
    public void deleteAssortment(Long id) {
        assortmentRepo.deleteById(id);
    }
}
