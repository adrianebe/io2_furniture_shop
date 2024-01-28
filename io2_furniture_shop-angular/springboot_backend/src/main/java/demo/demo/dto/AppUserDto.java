package demo.demo.dto;

import demo.demo.entity.enums.Role;

public record AppUserDto(
        Long id,
        String name,
        String lastName,
        String email,
        Role role
) {
}
