package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements IEntity<Appointment> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate date;

    @Enumerated
    private Status status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(LocalDate date, Status status, Patient patient, Doctor doctor) {
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.doctor = doctor;
    }

    public void set(Appointment a) {
        this.date = a.date;
        this.status = a.status;
        this.patient = a.patient;
        this.doctor = a.doctor;
    }

    public enum Status {
        FINISHED,
        CANCELED,
        ACTIVE
    }

}