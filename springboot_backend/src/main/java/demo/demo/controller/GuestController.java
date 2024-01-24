package demo.demo.controller;

import demo.demo.entity.Assortment;
import demo.demo.service.AssortmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/guest")
@RequiredArgsConstructor
public class GuestController {

    private final AssortmentService assortmentService;

    @GetMapping("assortment")
    public ResponseEntity<List<Assortment>> getAllAssortments() {
        List<Assortment> assortments = assortmentService.getAllAssortments();

        return ResponseEntity.ok(assortments);
    }

    @GetMapping("assortment/{assortmentId}")
    public ResponseEntity<Assortment> getAssortmentById(@PathVariable Long assortmentId) {
        Assortment assortment = assortmentService.getAssortmentById(assortmentId);

        return ResponseEntity.ok(assortment);
    }

    @GetMapping("assortment/{roomType}")
    public ResponseEntity<List<Assortment>> getAllAssortmentsByRoomType(@PathVariable String roomType) {
        List<Assortment> assortments = assortmentService.getAllAssortmentsByRoomType(roomType);

        return ResponseEntity.ok(assortments);
    }

    @GetMapping("assortment/{roomType}/{assortmentId}")
    public ResponseEntity<Assortment> getAssortmentByIdAndRoomType(@PathVariable Long assortmentId, @PathVariable String roomType) {
        Assortment assortment = assortmentService.getAssortmentByIdAndRoomType(assortmentId, roomType);

        return ResponseEntity.ok(assortment);
    }
}
