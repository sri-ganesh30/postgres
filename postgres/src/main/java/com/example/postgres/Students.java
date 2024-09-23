package com.example.postgres;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Students {
    @Id
    private int id;

    private String name;

    private int age;

    private long phone;
}
