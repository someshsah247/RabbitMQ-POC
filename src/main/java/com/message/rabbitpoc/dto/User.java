package com.message.rabbitpoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
