package edu.icet.entity.tbl;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "products")
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
    private String description;
    private String size;
    private String color;
    @Column(name = "unit_price")
    private Double price;
    private String category;
    private Integer qty;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String title, byte[] image, String description, String size, String color, Double price, String category, Integer qty) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.category = category;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image=" + (image != null ? "image data" : "null") +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", qty=" + qty +
                '}';
    }
}
