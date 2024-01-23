package demo.demo.service;

import demo.demo.entity.Assortment;

import java.util.List;

public interface AssortmentService {

    List<Assortment> getAllAssortments();

    Assortment getAssortmentById(Long assortmentId);

    List<Assortment> getAllAssortmentsByRoomType(String roomType);

    Assortment getAssortmentByIdAndRoomType(Long assortmentId, String roomType);

    void createNewAssortment(Assortment assortment);

    void updateAssortment(Long assortmentId, Assortment updatedAssortment);

    void deleteAssortment(Long assortmentId);

    boolean isAssortmentAvailable(Assortment assortment);
}
