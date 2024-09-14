package org.mannydev.deliveryapp1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "delivery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    private String id;
    private String name;
    private String address;
    private String phone;
    private Date currentDate;
    private List<ProductQuantity> products;
    private double total;
    private boolean delivered = false;
}


