package org.mannydev.deliveryapp1.Controller;

import org.mannydev.deliveryapp1.Model.Delivery;
import org.mannydev.deliveryapp1.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery saveDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Delivery> getDeliveries() {
        return deliveryService.getDeliveries();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Delivery getDeliveryById(@PathVariable String id) {
        return deliveryService.getDeliveryById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Delivery getDeliveryByName(@PathVariable String name) {
        return deliveryService.getDeliveryByName(name);
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Delivery updateDeliveryStatus(@PathVariable String id, @RequestParam boolean delivered) {
        return deliveryService.updateDeliveryStatus(id, delivered);
    }

    @GetMapping("/delivered/")
    @ResponseStatus(HttpStatus.OK)
    public Delivery getDeliveryByDelivered(@RequestParam boolean delivered) {
        return deliveryService.getDeliveryByDelivered(delivered);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteDelivery(@PathVariable String id) {
        return deliveryService.deleteDelivery(id);
    }
}
