package demo.demo.dto;

import demo.demo.entity.Assortment;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(
        Long id,
        List<Assortment> assortments,
        double price,
        int deliveryType,
        LocalDate deliveryDate
) {
}
