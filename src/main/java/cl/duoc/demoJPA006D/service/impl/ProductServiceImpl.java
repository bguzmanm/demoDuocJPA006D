package cl.duoc.demoJPA006D.service.impl;

import cl.duoc.demoJPA006D.dto.ProductDto;
import cl.duoc.demoJPA006D.model.Product;
import cl.duoc.demoJPA006D.model.mapper.ProductMapper;
import cl.duoc.demoJPA006D.repository.ProductRepository;
import cl.duoc.demoJPA006D.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public List<ProductDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<ProductDto> findByName(String name) {
        return repository.findByName(name).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDto> findByDescription(String description) {
        return repository.findByDescription(description).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ProductDto findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return mapper
                .toDto(repository
                        .save(mapper
                                .toEntity(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return mapper.toDto(repository.save(mapper.toEntity(productDto)));
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<ProductDto> findByStockMinusTen() {
        return repository.findByStockMinusTen()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDto> findByStockMinus(Double stockMin) {
        return repository.findByStockMinus(stockMin)
                .stream()
                .map(mapper::toDto).toList();

    }

    @Override
    public List<ProductDto> findSobreStock(Double stockMax) {
        return repository.findSobreStock(stockMax)
                .stream()
                .map(mapper::toDto).toList();
    }
}
