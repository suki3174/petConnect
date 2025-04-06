package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Product;
import com.petconnect.petconnect.Entities.Status_Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long id);
    public void deleteProduct(Long id);
    public List<Product> findByStatus(Status_Product status);
    public List<Product> findByTitleContaining(String keyword);
    public List<Product> findByPriceRange(Double minPrice, Double maxPrice);
    public void markAsSold(Long id);
    public List<Product> findByLocation(String location);
}
