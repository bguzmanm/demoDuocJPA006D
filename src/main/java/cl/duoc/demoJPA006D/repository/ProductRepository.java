package cl.duoc.demoJPA006D.repository;


import cl.duoc.demoJPA006D.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);

    // JPQL
    @Query("SELECT p FROM Product p WHERE p.stock < 10")
    List<Product> findByStockMinusTen();
    // JPQL
    @Query("SELECT p FROM Product p WHERE p.stock < :stockMin")
    List<Product> findByStockMinus(@Param("stockMin") Double stockMin);

    // SQL
    @Query(value ="select * from product p where p.stock > :stockMax", nativeQuery = true)
    List<Product> findSobreStock(Double stockMax);
}
