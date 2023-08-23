package com.ada.victorborzaquelstore.modules.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequestDto {
    private String name;
    private String email;
    private String cpf;
}
