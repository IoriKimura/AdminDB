package com.example.adminka3.DataBases.PostgreSQL.Models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "employee", schema = "public")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employeename")
    private String name;

    @Column(name = "employeelastname")
    private String lastName;

    @Column(name = "position")
    private String position;

    public Employee(String name, String lastName, String position) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }
}
