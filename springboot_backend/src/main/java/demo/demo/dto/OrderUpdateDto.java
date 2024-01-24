package demo.demo.dto;

import demo.demo.entity.enums.OrderStatus;

import java.time.LocalDate;

public record OrderUpdateDto(
        LocalDate deliveryDate,
        OrderStatus orderStatus
) {
}
