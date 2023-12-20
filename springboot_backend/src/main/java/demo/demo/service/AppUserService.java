package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppUserService {

    private  final AppUserRepo appUserRepo;

    public List<AppUser> getAppUsers(){
        return appUserRepo.findAll();
    }

    public void addNewUser(AppUser appUser){
        appUserRepo.save(appUser);
    }

    public void deleteUser(Long id){
        appUserRepo.deleteById(id);
    }
}
