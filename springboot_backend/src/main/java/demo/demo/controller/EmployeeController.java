package demo.demo.controller;

import demo.demo.entity.Assortment;
import demo.demo.service.AssortmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final AssortmentService assortmentService;

    @PostMapping("assortment")
    public ResponseEntity<?> addNewAssortment(@RequestBody Assortment assortment) {
        assortmentService.addNewAssortment(assortment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("assortment/{assortmentId}")
    public ResponseEntity<?> updateAssortment(@PathVariable Long assortmentId, @RequestBody Assortment assortment) {
        Assortment updatedAssortment = assortmentService.updateAssortment(assortmentId, assortment);

        return ResponseEntity.ok(updatedAssortment);
    }

    @DeleteMapping("assortment/{assortmentId}")
    public ResponseEntity<?> deleteAssortmentById(@PathVariable Long assortmentId) {
        assortmentService.deleteAssortment(assortmentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
