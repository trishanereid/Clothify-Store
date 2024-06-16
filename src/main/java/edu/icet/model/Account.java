package edu.icet.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {
    private String email;
    private String password;
    private String role;

    public Account(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
