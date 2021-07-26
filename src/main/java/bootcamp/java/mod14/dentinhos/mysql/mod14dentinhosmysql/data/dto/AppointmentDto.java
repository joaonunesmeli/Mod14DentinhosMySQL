package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    private LocalDate date;
    private Appointment.Status status;
    private PatientDto patient;
    private DoctorDto doctor;
}
