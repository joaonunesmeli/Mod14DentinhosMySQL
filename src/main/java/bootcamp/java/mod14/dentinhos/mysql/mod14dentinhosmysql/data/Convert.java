package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.DoctorDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.PatientDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.DoctorForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.PatientForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Appointment;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Doctor;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;

import java.util.List;
import java.util.stream.Collectors;

public final class Convert {
    private Convert() {}

    public static Doctor form(DoctorForm doc) {
        return new Doctor(doc.getFirstName(), doc.getLastName(), doc.getSpecialty());
    }

    public static DoctorDto entity(Doctor doc) {
        return new DoctorDto(doc.getFirstName(), doc.getLastName(), doc.getSpecialty());
    }

    public static Patient form(PatientForm p) {
        return new Patient(p.getFirstName(), p.getLastName(), p.getGender(), p.getAge());
    }

    public static PatientDto entity(Patient p) {
        return new PatientDto(p.getFirstName(), p.getLastName(), p.getGender(), p.getAge());
    }

    public static Appointment form(Doctor doc, Patient p, AppointmentForm turn) {
        return new Appointment(turn.getDate(), Appointment.Status.ACTIVE, p, doc);
    }

    public static AppointmentDto entity(Appointment a) {
        PatientDto p = Convert.entity(a.getPatient());
        DoctorDto doc = Convert.entity(a.getDoctor());
        return new AppointmentDto(a.getId(), a.getDate(), a.getStatus(), p, doc);
    }

    public static List<AppointmentDto> entities(List<Appointment> as) {
        return as.stream().map(Convert::entity).collect(Collectors.toList());
    }
}
