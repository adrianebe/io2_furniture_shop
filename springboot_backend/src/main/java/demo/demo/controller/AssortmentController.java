package demo.demo.controller;

import demo.demo.entity.Assortment;
import demo.demo.repository.AssortmentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/assortment")
public class AssortmentController {

    private final AssortmentRepo assortmentRepo;

    public AssortmentController(AssortmentRepo assortmentRepo) {
        this.assortmentRepo = assortmentRepo;
    }

    @GetMapping("get")
    public List<Assortment> getAssortment() {
        return assortmentRepo.findAll();
    }

    @GetMapping("{roomType}")
    public List<Assortment> getAssortmentByRoomType(@PathVariable String roomType) {
        return assortmentRepo.findAllByRoomType(roomType);
    }

    @GetMapping("{roomType}/{assortmentId}")
    public Assortment getAssortmentByIdAndRoomType(@PathVariable String roomType, @PathVariable Long assortmentId){
        return assortmentRepo.findOneByIdAndRoomType(assortmentId, roomType);
    }
    @PostMapping("add")
    public Assortment addNewAssortment(@RequestBody Assortment assortment) {
        return assortmentRepo.save(assortment);
    }

    @DeleteMapping("delete/{assortmentId}")
    public void deleteAssortment(@PathVariable Long assortmentId) {
        assortmentRepo.deleteById(assortmentId);
    }
}

