package pl.training.shop.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ProductStore {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String description;
    private Long quantity;
    private double unitPrice;

}
