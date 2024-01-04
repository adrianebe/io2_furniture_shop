package demo.demo.controller;

import demo.demo.entity.Assortment;
import demo.demo.service.AssortmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/assortment")
public class AssortmentController {

    private final AssortmentService assortmentService;


    @GetMapping()
    public List<Assortment> getAssortment() {
        return assortmentService.getAllAssortments();
    }

    @GetMapping("{roomType}")
    public List<Assortment> getAssortmentByRoomType(@PathVariable String roomType) {
        return assortmentService.getAllAssortmentsByRoomType(roomType);
    }

    @GetMapping("{roomType}/{assortmentId}")
    public Assortment getAssortmentByIdAndRoomType(@PathVariable String roomType, @PathVariable Long assortmentId) {
        return assortmentService.getAssortmentByIdAndRoomType(roomType, assortmentId);
    }

    @PostMapping()
    public Assortment addNewAssortment(@RequestBody Assortment assortment) {
        return assortmentService.addNewAssortment(assortment);
    }

    @DeleteMapping("{assortmentId}")
    public void deleteAssortment(@PathVariable Long assortmentId) {
        assortmentService.deleteAssortment(assortmentId);
    }
}

