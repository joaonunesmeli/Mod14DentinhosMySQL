package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements IEntity<Patient> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double age;

    public Patient(String firstName, String lastName, Gender gender, double age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public void set(Patient p) {
        this.firstName = p.firstName;
        this.lastName = p.lastName;
        this.gender = p.gender;
        this.age = p.age;
    }

    public enum Gender {
        FEMALE {
            @Override
            public String toString() {
                return "Female";
            }
        },

        MALE {
            @Override
            public String toString() {
                return "Male";
            }
        }
    }

}
