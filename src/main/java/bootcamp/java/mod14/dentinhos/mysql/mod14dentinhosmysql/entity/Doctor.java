package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor implements IEntity<Doctor> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    private String specialty;

    public Doctor(String firstName, String lastName, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public void set(Doctor doc) {
        this.firstName = doc.firstName;
        this.lastName = doc.lastName;
        this.specialty = doc.specialty;
    }

}