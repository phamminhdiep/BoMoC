package com.example.BoMoC.model.product;

import com.example.BoMoC.model.customer.Customer;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CustomerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @OneToOne
    private Star star;
    @OneToOne
    private Comment comment;
    @OneToOne
    private Customer customer;

    @ManyToOne
    private Product product;

}
