package demo.demo.service;

public interface AuthService {
    boolean validateCredentials(String email, String password);

    boolean registerUser(String name, String lastName, String email, String password);

    String getJwtToken(String email);
}
