package com.mac9p.rentapp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Disc> DiscsRented;
    private String firstName;
    private String lastName;

    public User(List<Disc> discsRented, String firstName, String lastName) {
        DiscsRented = discsRented;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
