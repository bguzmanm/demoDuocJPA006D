package cl.duoc.demoJPA006D.model.mapper;

import cl.duoc.demoJPA006D.dto.ProductDto;
import cl.duoc.demoJPA006D.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);
    List<ProductDto> toDtoList(List<Product> products);
}
