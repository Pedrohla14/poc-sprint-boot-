package model;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_pessoa")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birth;
    private String fone;

    public PersonModel(String name, String cpf, String email, LocalDate birth, String fone) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birth = birth;
        this.fone = fone;
    }
}
