package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorForm {

    @NotNull(message = "Nome é um campo obrigatório")
    @Size(min = 2, message = "O nome deve ter no mínimo dois caracteres")
    private String firstName;

    @NotNull(message = "Sobrenome é um campo obrigatório")
    @Size(min = 2, message = "O sobrenome deve ter no mínimo dois caracteres")
    private String lastName;

    @NotNull(message = "Especialidade é um campo obrigatório")
    @Size(min = 4, message = "A especialidade deve ter no mínimo quatro caracteres")
    private String specialty;

}
