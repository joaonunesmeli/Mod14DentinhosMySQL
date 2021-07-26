package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientForm {

    @NotNull(message = "Nome é um campo obrigatório")
    @Size(min = 4, message = "O nome deve ter no mímimo 4 caracteres")
    private String firstName;

    @NotNull(message = "Sobrenome é um campo obrigatório")
    @Size(min = 4, message = "O sobrenome deve ter no mímimo 4 caracteres")
    private String lastName;

    @NotNull(message = "Idade é um campo obrigatório")
    @Positive(message = "A idade deve ser um valor positivo")
    private double age;

    @NotNull(message = "Sexo é um campo obrigatório")
    private Patient.Gender gender;

}
