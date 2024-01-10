package demo.demo.mapper;

import demo.demo.dto.OrderDto;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-10T19:18:01+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto mapToDto(Order order) {
        if ( order == null ) {
            return null;
        }

        Long id = null;
        List<Assortment> assortments = null;
        double price = 0.0d;
        int deliveryType = 0;
        LocalDate deliveryDate = null;

        id = order.getId();
        List<Assortment> list = order.getAssortments();
        if ( list != null ) {
            assortments = new ArrayList<Assortment>( list );
        }
        price = order.getPrice();
        deliveryType = order.getDeliveryType();
        deliveryDate = order.getDeliveryDate();

        OrderDto orderDto = new OrderDto( id, assortments, price, deliveryType, deliveryDate );

        return orderDto;
    }
}
