package demo.demo.mapper;

import demo.demo.dto.AppUserDto;
import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-28T12:23:59+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class AppUserMapperImpl implements AppUserMapper {

    @Override
    public AppUserDto mapToResponse(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String lastName = null;
        String email = null;
        Role role = null;

        id = appUser.getId();
        name = appUser.getName();
        lastName = appUser.getLastName();
        email = appUser.getEmail();
        role = appUser.getRole();

        AppUserDto appUserDto = new AppUserDto( id, name, lastName, email, role );

        return appUserDto;
    }
}
