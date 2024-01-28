package demo.demo.dto;

import demo.demo.entity.enums.ComplaintStatus;

public record ComplaintDto(
        Long id,
        String response,
        ComplaintStatus status
) {
}
