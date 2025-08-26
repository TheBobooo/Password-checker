package com.pass.passwordchecker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Using Lombok for boilerplate code

@Entity // Marks this class as a JPA entity, mapping to a database table
@Table(name = "common_passwords") // Specifies the table name in the database
@Data // Lombok annotation to automatically generate getters, setters, toString, equals, hashCode
public class CommonPassword {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures auto-incrementing ID
    private Long id;

    @Column(nullable = false, unique = true, length = 255) // Column constraints: not null, unique, max length
    private String password;

    // Lombok's @Data will generate constructors, getters, setters, etc.
    // If you're not using Lombok, you would need to manually add:
    // public CommonPassword() {} // Default constructor
    // public CommonPassword(String password) { this.password = password; } // Constructor for convenience
    // public Long getId() { return id; }
    // public void setId(Long id) { this.id = id; }
    // public String getPassword() { return password; }
    // public void setPassword(String password) { this.password = password; }
}