package com.petconnect.petconnect.services;

import com.petconnect.petconnect.Entities.Product;
import com.petconnect.petconnect.Entities.Status_Product;
import com.petconnect.petconnect.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findByStatus(Status_Product status) {
        return productRepo.findByStatus(status);
    }

    @Override
    public List<Product> findByTitleContaining(String keyword) {
        return productRepo.findByTitleContaining(keyword);
    }

    @Override
    public List<Product> findByPriceRange(Double minPrice, Double maxPrice) {
        return productRepo.findByPriceRange(minPrice, maxPrice);
    }

    @Override
    public void markAsSold(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setStatus(Status_Product.sold);
            productRepo.save(product);
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " not found.");
        }
    }

    @Override
    public List<Product> findByLocation(String location) {
        return productRepo.findByLocation(location);
    }
}
