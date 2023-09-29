package com.creditville.creditvilletask.DTO.requestDTO;


import com.creditville.creditvilletask.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class registerDTO {

    private String email;

    private String password;

    private Role role;

}
