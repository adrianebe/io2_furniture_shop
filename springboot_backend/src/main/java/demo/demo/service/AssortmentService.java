package demo.demo.service;

import demo.demo.entity.Assortment;

import java.util.List;

public interface AssortmentService {

    List<Assortment> getAllAssortments();

    List<Assortment> getAllAssortmentsByRoomType(String roomType);

    Assortment getAssortmentByIdAndRoomType(String roomType, Long assortmentId);

    Assortment addNewAssortment(Assortment assortment);

    void deleteAssortment(Long id);
}
