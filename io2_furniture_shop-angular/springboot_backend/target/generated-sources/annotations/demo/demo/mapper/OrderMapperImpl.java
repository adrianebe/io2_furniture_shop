package demo.demo.mapper;

import demo.demo.dto.AssortmentDto;
import demo.demo.dto.OrderDto;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import demo.demo.entity.enums.OrderStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-25T11:46:51+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto mapToDto(Order order) {
        if ( order == null ) {
            return null;
        }

        Long id = null;
        List<AssortmentDto> assortments = null;
        double price = 0.0d;
        int deliveryType = 0;
        LocalDate deliveryDate = null;
        OrderStatus orderStatus = null;
        String deliveryAddress = null;

        id = order.getId();
        assortments = assortmentListToAssortmentDtoList( order.getAssortments() );
        price = order.getPrice();
        deliveryType = order.getDeliveryType();
        deliveryDate = order.getDeliveryDate();
        orderStatus = order.getOrderStatus();
        deliveryAddress = order.getDeliveryAddress();

        OrderDto orderDto = new OrderDto( id, assortments, price, deliveryType, deliveryDate, orderStatus, deliveryAddress );

        return orderDto;
    }

    protected AssortmentDto assortmentToAssortmentDto(Assortment assortment) {
        if ( assortment == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        double price = 0.0d;

        id = assortment.getId();
        name = assortment.getName();
        price = assortment.getPrice();

        AssortmentDto assortmentDto = new AssortmentDto( id, name, price );

        return assortmentDto;
    }

    protected List<AssortmentDto> assortmentListToAssortmentDtoList(List<Assortment> list) {
        if ( list == null ) {
            return null;
        }

        List<AssortmentDto> list1 = new ArrayList<AssortmentDto>( list.size() );
        for ( Assortment assortment : list ) {
            list1.add( assortmentToAssortmentDto( assortment ) );
        }

        return list1;
    }
}
