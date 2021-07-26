package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentForm {

    @NotNull(message = "Data é um campo obrigatório")
    @Future(message = "A data deve ser de um dia futuro")
    private LocalDate date;

}
