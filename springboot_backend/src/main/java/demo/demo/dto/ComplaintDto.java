package demo.demo.dto;

import demo.demo.entity.enums.ComplaintStatus;

public record ComplaintDto(
        String description,
        ComplaintStatus status
) {
}
