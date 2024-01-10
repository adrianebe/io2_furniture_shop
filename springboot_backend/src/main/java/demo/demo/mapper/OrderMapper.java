package demo.demo.mapper;

import demo.demo.dto.OrderDto;
import demo.demo.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto mapToDto(Order order);
}
