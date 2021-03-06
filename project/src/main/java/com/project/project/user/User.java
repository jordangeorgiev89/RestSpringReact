package com.project.project.user;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 4, max = 255)
    private String username;
    @NotNull
    @Size(min = 4)
    private String displayName;
    @NotNull
    @Size(min = 8)
    private String password;


}
