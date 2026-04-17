package cl.duoc.demoJPA006D.service;

import cl.duoc.demoJPA006D.dto.ProductDto;
import cl.duoc.demoJPA006D.model.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    List<ProductDto> findByName(String name);
    List<ProductDto> findByDescription(String description);
    ProductDto findById(Long id);
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto);
    boolean delete(Long id);
    List<ProductDto> findByStockMinusTen();
    List<ProductDto> findByStockMinus(Double stockMin);
    List<ProductDto> findSobreStock(Double stockMax);
}
