package edu.icet.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "employees")
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String phoneNo;
    private String email;
    private String role;
    private String password;

    public EmployeeEntity() {}

    public EmployeeEntity(String firstName, String lastName, String address, String phoneNo, String email, String role,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.role = role;
        this.password = password;
    }
}
