package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String cusId;
    private String status;
    private Date date;
    private Double amount;
    private String empId;
}
