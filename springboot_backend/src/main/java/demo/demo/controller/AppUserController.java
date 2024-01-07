package demo.demo.controller;

import demo.demo.dto.request.AppUserRequest;
import demo.demo.dto.response.AppUserResponse;
import demo.demo.mapper.AppUserMapper;
import demo.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;

    @GetMapping()
    public ResponseEntity<List<AppUserResponse>> getAppUsers() {
        List<AppUserResponse> appUsers = appUserService.getAllAppUsers()
                .stream()
                .map(appUserMapper::mapToResponse)
                .toList();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AppUserResponse> addAppUser(@RequestBody AppUserRequest appUser) {
        AppUserResponse newAppUser = appUserMapper
                .mapToResponse(appUserService.addNewAppUser(appUserMapper.mapToEntity(appUser)));
        return new ResponseEntity<>(newAppUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        appUserService.deleteAppUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
