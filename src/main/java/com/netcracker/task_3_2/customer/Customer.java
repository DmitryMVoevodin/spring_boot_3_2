package com.netcracker.task_3_2.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @ApiModelProperty(notes = "Customer's id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerid", nullable = false)
    private Integer customerId;

    @ApiModelProperty(notes = "Customer's second name")
    @NonNull
    @Column(name = "secondname", nullable = false)
    private String secondName;

    @ApiModelProperty(notes = "Customer's adress of the place, where he lives")
    @NonNull
    @Column(name = "inhabitation", nullable = false)
    private String inhabitation;

    @ApiModelProperty(notes = "Discount in percentages")
    @NonNull
    @Column(name = "discount", nullable = false)
    private double discount;

    public Integer getCustomerId() {
        return customerId;
    }
}