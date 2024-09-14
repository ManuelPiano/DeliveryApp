package org.mannydev.deliveryapp1.Service;

import org.mannydev.deliveryapp1.Exceptions.ProductNotFoundException;
import org.mannydev.deliveryapp1.Model.Product;
import org.mannydev.deliveryapp1.Reposiitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        product.setId(UUID.randomUUID().toString().split("-")[0]);
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByAvailable(boolean available) {
        return productRepository.findByAvailable(available);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct == null) {
            throw new ProductNotFoundException("Product not found with id: " + product.getId());
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setAvailable(product.isAvailable());
        return productRepository.save(existingProduct);
    }
    public List<Product> getProductsByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

    public String deleteProduct(String id) {
        productRepository.deleteById(id);
        return "Product removed !! " + id;
    }

}
