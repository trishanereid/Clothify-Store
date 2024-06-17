package edu.icet.bo.product;

import edu.icet.entity.ProductEntity;
import edu.icet.model.Product;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class AddProductService {
    Stage stage;
    ModelMapper mapper = new ModelMapper();
    String imagePath;
    public String imageUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose the image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All","*.png","*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png")
                );
        File file = fileChooser.showOpenDialog(stage);
        imagePath = file.getPath();
        return imagePath;
    }

    public void saveProduct(Product product) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        File file = new File(imagePath);
        byte[] imageByte = null;
        try {
            imageByte = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImage(imageByte);

        entityManager.persist(
                mapper.map(product, ProductEntity.class)
        );
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
