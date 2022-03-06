package com.example.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class Author {
    @NotEmpty(message = "ID can't be empty")
    @Size(min = 3,max = 8 , message = "ID size must be more than 3 and less than 8")
    private String id;
    @NotEmpty(message = "Name can't be empty")
    @Size(min = 3,max=5,message = "Name size must be more than 3 and less than 5")
    private String name;
    @Email(message = "Please enter valid email")
    @NotEmpty(message = "Email can't be empty")
    private String email;
    @NotEmpty(message = "Gender can't be empty")
    @Size(max = 1,min = 1,message = "Gender can't be more than 1 char")
    private String gender;

}




