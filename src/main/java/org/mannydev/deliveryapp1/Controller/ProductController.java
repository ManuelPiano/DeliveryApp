package org.mannydev.deliveryapp1.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.mannydev.deliveryapp1.Model.Product;
import org.mannydev.deliveryapp1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByNameContaining(@RequestParam String name) {
        return productService.getProductsByNameContaining(name);
    }

    @GetMapping("/available/{available}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductByAvailable(@PathVariable boolean available) {
        return productService.getProductByAvailable(available);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Borrar producto", description = "Borra un producto por su id")
    public String deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
