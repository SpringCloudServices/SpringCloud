package pl.training.shop.payment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Payment {

    @GeneratedValue
    @Id
    private String userLogin;
    private Double paymentAmount;
    private String paymentStatus;
    private Date paymentDate;

}
