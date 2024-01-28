package demo.demo.dto;

import demo.demo.entity.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(
        Long id,
        List<AssortmentDto> assortments,
        double price,
        int deliveryType,
        LocalDate deliveryDate,
        OrderStatus orderStatus,
        String deliveryAddress
) {
}
