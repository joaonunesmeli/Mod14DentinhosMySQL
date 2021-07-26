package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.Convert;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.PatientDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.PatientForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient, PatientForm, PatientDto> {
    private PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository) {
        super(repository, Convert::form, Convert::entity);
        this.repository = repository;
    }
}
