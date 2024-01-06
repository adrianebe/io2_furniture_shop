package demo.demo.mapper;

import demo.demo.dto.request.AppUserRequest;
import demo.demo.dto.response.AppUserResponse;
import demo.demo.entity.AppUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-06T16:44:04+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class AppUserMapperImpl implements AppUserMapper {

    @Override
    public AppUser mapToEntity(AppUserRequest appUserRequest) {
        if ( appUserRequest == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setName( appUserRequest.name() );
        appUser.setLastName( appUserRequest.lastName() );
        appUser.setEmail( appUserRequest.email() );
        appUser.setPassword( appUserRequest.password() );

        return appUser;
    }

    @Override
    public AppUserResponse mapToResponse(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String lastName = null;

        id = appUser.getId();
        name = appUser.getName();
        lastName = appUser.getLastName();

        AppUserResponse appUserResponse = new AppUserResponse( id, name, lastName );

        return appUserResponse;
    }
}
