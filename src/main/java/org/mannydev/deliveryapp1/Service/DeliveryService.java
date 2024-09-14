package org.mannydev.deliveryapp1.Service;

import org.mannydev.deliveryapp1.Exceptions.DeliveryNotDeliveredException;
import org.mannydev.deliveryapp1.Exceptions.DeliveryNotFoundException;
import org.mannydev.deliveryapp1.Model.Delivery;
import org.mannydev.deliveryapp1.Reposiitory.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepo deliveryRepo;

    public Delivery saveDelivery(Delivery delivery) {
        delivery.setId(UUID.randomUUID().toString().split("-")[0]);
        return deliveryRepo.save(delivery);
    }

    public List<Delivery> getDeliveries() {
        return deliveryRepo.findAll();
    }

    public Delivery getDeliveryById(String id) {
        return deliveryRepo.findById(id).orElse(null);
    }

    public Delivery getDeliveryByName(String name) {
        return deliveryRepo.findByName(name);
    }

    public Delivery getDeliveryByDelivered(boolean delivered) {
        return deliveryRepo.findByDelivered(delivered);
    }

    public Delivery updateDeliveryStatus(String id, boolean delivered) {
        Delivery existingDelivery = deliveryRepo.findById(id).orElse(null);
        if (existingDelivery == null) {
            throw new DeliveryNotFoundException("Delivery not found with id: " + id);
        }
        existingDelivery.setDelivered(delivered);
        return deliveryRepo.save(existingDelivery);
    }

    public String deleteDelivery(String id) {
        deliveryRepo.deleteById(id);
        return "Delivery removed !! " + id;
    }


}
