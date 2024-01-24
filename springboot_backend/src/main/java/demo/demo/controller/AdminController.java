package demo.demo.controller;

import demo.demo.dto.AppUserDto;
import demo.demo.entity.AppUser;
import demo.demo.mapper.AppUserMapper;
import demo.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;

    @GetMapping("users")
    public ResponseEntity<List<AppUserDto>> getAllAppUsers() {
        return ResponseEntity.ok
                (appUserService.getAllAppUsers()
                        .stream()
                        .map(appUserMapper::mapToResponse)
                        .toList());
    }

    @GetMapping("users/{enabled}")
    public ResponseEntity<List<AppUserDto>> getAllActiveOrNotActiveAppUsers(@PathVariable boolean enabled) {
        return ResponseEntity.ok(
                appUserService.getAllActiveOrNotActiveAppUsers(enabled)
                        .stream()
                        .map(appUserMapper::mapToResponse)
                        .toList());
    }

    @PostMapping("users")
    public ResponseEntity<?> addNewAppUser(@RequestBody AppUser appUser) {
        appUserService.createNewAppUser(appUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("users/{appUserId}")
    public ResponseEntity<?> updateAppUser(@PathVariable Long appUserId, @RequestBody AppUser appUser) {
        appUserService.updateAppUser(appUserId, appUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("users/{appUserId}")
    public ResponseEntity<?> deleteAppUser(@PathVariable Long appUserId) {
        appUserService.deleteAppUser(appUserId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
