package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
