package demo.demo.mapper;

import demo.demo.dto.AppUserDto;
import demo.demo.entity.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUserDto mapToResponse(AppUser appUser);
}
