package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeModel {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String email;
    private String role;
    private String password;
}
