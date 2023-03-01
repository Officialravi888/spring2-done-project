package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=4,message = "name should have min of 4 characters")
    @NotEmpty(message="name should not be null")
    private String name;
    private int age;
    @Email
    private String email;

}