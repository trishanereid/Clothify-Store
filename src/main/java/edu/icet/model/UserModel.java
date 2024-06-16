package edu.icet.model;

import javafx.beans.property.SimpleStringProperty;
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
public class UserModel {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String email;
    private String role;
    private String password;

}
