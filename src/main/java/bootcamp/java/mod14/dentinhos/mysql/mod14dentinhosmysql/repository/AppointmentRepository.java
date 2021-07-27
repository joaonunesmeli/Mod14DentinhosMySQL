package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor_Id(long id);

    List<Appointment> findByStatus(Appointment.Status status);
}
