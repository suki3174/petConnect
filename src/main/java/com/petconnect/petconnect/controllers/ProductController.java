package com.petconnect.petconnect.controllers;

import com.petconnect.petconnect.Entities.Product;
import com.petconnect.petconnect.Entities.Status_Product;
import com.petconnect.petconnect.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/status/{status}")
    public List<Product> getProductsByStatus(@PathVariable Status_Product status) {
        return productService.findByStatus(status);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByTitle(@RequestParam String keyword) {
        return productService.findByTitleContaining(keyword);
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return productService.findByPriceRange(minPrice, maxPrice);
    }

    @PutMapping("/{id}/sold")
    public void markProductAsSold(@PathVariable Long id) {
        productService.markAsSold(id);
    }

    @GetMapping("/location/{location}")
    public List<Product> getProductsByLocation(@PathVariable String location) {
        return productService.findByLocation(location);
    }
}
