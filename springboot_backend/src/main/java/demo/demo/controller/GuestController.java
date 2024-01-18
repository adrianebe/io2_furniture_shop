package demo.demo.controller;

import demo.demo.entity.Assortment;
import demo.demo.service.AssortmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/guest")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GuestController {

    private final AssortmentService assortmentService;

    @GetMapping("assortment")
    public ResponseEntity<List<Assortment>> getAssortment() {
        return ResponseEntity.ok(assortmentService.getAllAssortments());
    }

    @GetMapping("assortment/{roomType}")
    public ResponseEntity<List<Assortment>> getAssortmentByRoomType(@PathVariable String roomType) {
        return ResponseEntity.ok(assortmentService.getAllAssortmentsByRoomType(roomType));
    }

    @GetMapping("assortment/{roomType}/{assortmentId}")
    public ResponseEntity<Assortment> getAssortmentByIdAndRoomType(@PathVariable String roomType, @PathVariable Long assortmentId) {
        return ResponseEntity.ok(assortmentService.getAssortmentByIdAndRoomType(roomType, assortmentId));
    }
}
