package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.PatientDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.PatientForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Patient;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController extends BaseController<Patient, PatientForm, PatientDto> {
    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        super(service);
        this.service = service;
    }
}
