package org.mannydev.deliveryapp1.Reposiitory;

import org.mannydev.deliveryapp1.Model.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepo extends MongoRepository<Delivery, String> {
    Delivery findByName(String name);
    Delivery findByDelivered(boolean delivered);
}
