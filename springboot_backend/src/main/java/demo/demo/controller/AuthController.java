package demo.demo.controller;

import demo.demo.dto.LoginDto;
import demo.demo.dto.RegisterDto;
import demo.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            if (!authService.validateCredentials(loginDto.email(), loginDto.password())) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }        String jwtToken = authService.getJwtToken(loginDto.email());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtToken);

        return ResponseEntity.ok().headers(headers).body("Login successful");
    }



    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        authService.registerUser(
                registerDto.name(),
                registerDto.lastName(),
                registerDto.email(),
                registerDto.password());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}