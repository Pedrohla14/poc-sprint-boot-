package controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDto {

    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 11,max = 11,message = "CPF deverá ter 11 caracteres e somente números.")
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private LocalDate birth;
    private String fone;

}