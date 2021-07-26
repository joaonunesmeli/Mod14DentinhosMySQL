package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentBatchForm {
    @Valid
    @NotNull(message = "Agendamentos é um campo obrigatório")
    @Size(min = 2, message = "Devem ser feitos no mínimo dois agendamentos")
    private List<AppointmentForm> appointments;
}
