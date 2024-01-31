package demo.demo.dto;

import java.util.Map;

public record AssortmentMapDto(
        Map<Long, Integer> assortmentIdsAndCount,

        String deliveryAddress
) {
}
