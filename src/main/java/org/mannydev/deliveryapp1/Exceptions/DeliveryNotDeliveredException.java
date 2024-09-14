package org.mannydev.deliveryapp1.Exceptions;

public class DeliveryNotDeliveredException extends RuntimeException {
    public DeliveryNotDeliveredException(String message) {
        super(message);
    }
}
