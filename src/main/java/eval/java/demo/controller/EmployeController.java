package eval.java.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import eval.java.demo.dao.EmployeDao;
import eval.java.demo.model.Employe;
import eval.java.demo.view.ViewEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeController {

    EmployeDao employeDao;

    @Autowired
    public EmployeController(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    @GetMapping("/employe/{id}")
    @JsonView(ViewEmploye.class)
    public Employe employe(@PathVariable int id) {
       return employeDao.findById(id).orElse(null);
    }

    @GetMapping("/liste-employe")
    @JsonView(ViewEmploye.class)
    public List<Employe> listeEmploye() {
        List<Employe> employes = this.employeDao.findAll();
        return employes;
    }

    @GetMapping("/compte-administrateur")
    @JsonView(ViewEmploye.class)
    public Integer compteAdministrateur() {
        return employeDao.compteAdministrateur();
    }
}