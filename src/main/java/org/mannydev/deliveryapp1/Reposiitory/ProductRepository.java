package org.mannydev.deliveryapp1.Reposiitory;

import org.mannydev.deliveryapp1.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Product> findByNameContaining(String name);
    Product findByAvailable(boolean available);
}
