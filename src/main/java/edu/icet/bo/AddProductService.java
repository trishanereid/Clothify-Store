package edu.icet.bo;

import edu.icet.entity.EmployeeEntity;
import edu.icet.entity.tbl.ProductEntity;
import edu.icet.model.tbl.ProductModel;
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

    public void saveProduct(ProductModel product) {
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





//        // Load image from file
//        File file = new File("path/to/your/image.jpg");
//        byte[] imageBytes = null;
//        try {
//            imageBytes = Files.readAllBytes(file.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Create ImageEntity object
//        ImageEntity imageEntity = new ImageEntity();
//        imageEntity.setName(file.getName());
//        imageEntity.setImage(imageBytes);
//
//        // Save ImageEntity object to the database
//        session.save(imageEntity);
    }
}