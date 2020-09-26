package com.schoolofnet.helpdesk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Can not be empty")
    private String email;
    
    @Column
    @NotEmpty(message = "Can not be empty")
    private String name;
    
    @Column
    @NotEmpty(message = "Can not be empty")
    private String lastName;
    
    @Column
    @NotEmpty(message = "Can not be empty")
    @Length(min = 5, message = "You need to provide a password that contains at least 5 characteres")
    private String password;
    
    @Column
    private Boolean active;

    public User(String email, String name, String lastName, String password, Boolean active) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

}
