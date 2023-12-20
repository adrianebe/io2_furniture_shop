package demo.demo.controller;

import demo.demo.dto.response.AppUserResponse;
import demo.demo.entity.AppUser;
import demo.demo.mapper.AppUserMapper;
import demo.demo.repository.AppUserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final AppUserRepo appUserRepo;
    private final AppUserMapper appUserMapper;

    public UserController(AppUserRepo appUserRepo, AppUserMapper appUserMapper) {
        this.appUserRepo = appUserRepo;
        this.appUserMapper = appUserMapper;
    }

    @GetMapping("get")
    public List<AppUserResponse> getAppUsers() {
        return appUserRepo.findAll()
                .stream()
                .map(appUserMapper::mapToResponse)
                .toList();
    }

    @PostMapping("add")
    public AppUser addAppUser(@RequestBody AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        appUserRepo.deleteById(userId);
    }
}
