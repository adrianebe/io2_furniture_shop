package demo.demo.mapper;

import demo.demo.dto.request.AppUserRequest;
import demo.demo.dto.response.AppUserResponse;
import demo.demo.entity.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUser mapToEntity(AppUserRequest appUserRequest);
    AppUserResponse mapToResponse(AppUser appUser);
}
