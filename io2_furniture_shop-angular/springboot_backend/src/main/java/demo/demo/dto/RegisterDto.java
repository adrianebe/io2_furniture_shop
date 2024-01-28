package demo.demo.dto;

public record RegisterDto(
        String name,
        String lastName,
        String email,
        String password
) {
}
