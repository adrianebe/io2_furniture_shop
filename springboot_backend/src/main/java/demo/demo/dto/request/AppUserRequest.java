package demo.demo.dto.request;

public record AppUserRequest(
        String email,
        String name,
        String lastName,
        String password
) {
}
