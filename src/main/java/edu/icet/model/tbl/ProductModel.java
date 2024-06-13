package edu.icet.model.tbl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel {
    private String title;
    private byte[] image;
    private String description;
    private String size;
    private String color;
    private Double price;
    private String category;
    private Integer qty;
}
