package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.Convert;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.DoctorDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.DoctorForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Doctor;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorService extends BaseService<Doctor, DoctorForm, DoctorDto> {
    private DoctorRepository repository;

    @Autowired
    public DoctorService(DoctorRepository repository) {
        super(repository, Convert::form, Convert::entity);
        this.repository = repository;
    }
}
