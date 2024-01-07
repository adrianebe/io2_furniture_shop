package demo.demo.service;

import demo.demo.entity.Assortment;

import java.util.List;

public interface AssortmentService {

    List<Assortment> getAllAssortments();

    Assortment getAssortmentById(Long assortmentId);

    List<Assortment> getAllAssortmentsByRoomType(String roomType);

    Assortment getAssortmentByIdAndRoomType(String roomType, Long assortmentId);

    Assortment addNewAssortment(Assortment assortment);

    Assortment updateAssortment(Long assortmentId, Assortment updatedAssortment);

    void deleteAssortment(Long assortmentId);
}
