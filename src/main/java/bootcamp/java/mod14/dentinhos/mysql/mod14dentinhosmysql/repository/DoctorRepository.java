package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
