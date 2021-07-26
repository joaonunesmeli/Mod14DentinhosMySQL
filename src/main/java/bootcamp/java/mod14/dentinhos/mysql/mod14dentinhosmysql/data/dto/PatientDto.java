package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private String firstName;
    private String lastName;
    private Patient.Gender gender;
    private double age;
}
