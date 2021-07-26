package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.Convert;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.AppointmentDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.IdDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.AppointmentForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Appointment;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Doctor;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.AppointmentNotFoundException;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.DoctorNotFoundException;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.exception.PatientNotFoundException;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository.AppointmentRepository;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository.DoctorRepository;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private AppointmentRepository repository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository repository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.repository = repository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public IdDto create(long doctorId, long patientId, AppointmentForm form) {
        Optional<Doctor> doc = this.doctorRepository.findById(doctorId);
        if (doc.isEmpty()) {
            throw new DoctorNotFoundException(doctorId);
        }

        Optional<Patient> p = this.patientRepository.findById(patientId);
        if (p.isEmpty()) {
            throw new PatientNotFoundException(patientId);
        }

        Appointment a = Convert.form(doc.get(), p.get(), form);
        return new IdDto(this.repository.save(a).getId());
    }

    public IdDto update(long id, Appointment.Status status) {
        Optional<Appointment> opt = this.repository.findById(id);
        if (opt.isEmpty()) {
            throw new AppointmentNotFoundException(id);
        }
        Appointment saved = opt.get();
        saved.setStatus(status);

        this.repository.save(saved);
        return new IdDto(id);
    }

    public List<AppointmentDto> getByDoctorId(long doctorId) {
        return Convert.entities(this.repository.findByDoctor_Id(doctorId));
    }

    public List<AppointmentDto> getByStatus(String status) {
        return Convert.entities(this.repository.findByStatus(status));
    }
}
