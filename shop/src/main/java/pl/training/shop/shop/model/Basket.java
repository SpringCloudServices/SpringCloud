package pl.training.shop.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
public class Basket {

    @GeneratedValue
    @Id
    private Long id;
    private String userLogin;
    private String productName;
    private Long prodQuantity;
    private double unitPrice;

}
