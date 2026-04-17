package cl.duoc.demoJPA006D.controller;

import cl.duoc.demoJPA006D.dto.ProductDto;
import cl.duoc.demoJPA006D.repository.ProductRepository;
import cl.duoc.demoJPA006D.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/minus-ten")
    public ResponseEntity<List<ProductDto>> findByStockMinusTen() {
        return ResponseEntity.ok(service.findByStockMinusTen());
    }

    @GetMapping("/minus/{stockMin}")
    public ResponseEntity<List<ProductDto>> findByStockMinus(@PathVariable("stockMin") Double stockMin) {
        return ResponseEntity.ok(service.findByStockMinus(stockMin));
    }

    @GetMapping("/max/{stockMax}")
    public ResponseEntity<List<ProductDto>> findSobreStock(@PathVariable("stockMax") Double stockMax) {
        return ResponseEntity.ok(service.findSobreStock(stockMax));
    }
}
