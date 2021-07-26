package bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.controller;

import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.dto.DoctorDto;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.data.form.DoctorForm;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.entity.Doctor;
import bootcamp.java.mod14.dentinhos.mysql.mod14dentinhosmysql.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController extends BaseController<Doctor, DoctorForm, DoctorDto> {
    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        super(service);
        this.service = service;
    }
}
