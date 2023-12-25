package demo.demo.controller;

import demo.demo.dto.response.AppUserResponse;
import demo.demo.entity.AppUser;
import demo.demo.mapper.AppUserMapper;
import demo.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;

    @GetMapping("get")
    public List<AppUserResponse> getAppUsers() {
        return appUserService.getAllAppUsers()
                .stream()
                .map(appUserMapper::mapToResponse)
                .toList();
    }

    @PostMapping("add")
    public AppUser addAppUser(@RequestBody AppUser appUser) {
        return appUserService.addNewAppUser(appUser);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        appUserService.deleteAppUser(userId);
    }
}
