package com.petconnect.petconnect.repositories;

import com.petconnect.petconnect.Entities.Product;
import com.petconnect.petconnect.Entities.Status_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByStatus(Status_Product status); // AVAILABLE or SOLD

    List<Product> findByTitleContaining(String keyword); // case-insensitive keyword search in title

    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findByPriceRange(Double minPrice, Double maxPrice); // range search if price is a Double

    List<Product> findByLocation(String location);
}
