package demo.demo.service;

public interface AuthService {
    void validateCredentials(String email, String password);

    void registerUser(String name, String lastName, String email, String password);

    String getJwtToken(String email);
}
