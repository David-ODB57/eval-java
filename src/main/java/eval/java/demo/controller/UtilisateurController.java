package eval.java.demo.controller;

import eval.java.demo.dao.EmployeDao;
import eval.java.demo.dao.UtilisateurDao;
import eval.java.demo.model.Employe;
import eval.java.demo.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    UtilisateurDao utilisateurDao;

    EmployeDao employeDao;

    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao, EmployeDao employeDao) {
        this.utilisateurDao = utilisateurDao;
        this.employeDao = employeDao;
    }

    @GetMapping("/compte-utilisateur")
    public Integer compteUtilisateur() {
        return utilisateurDao.compteUtilisateur();
    }

    @DeleteMapping("/utilisateur/{login}")
    public String supprimeUtilisateur(@PathVariable String login) {

       Utilisateur user =  utilisateurDao.findByLogin(login).orElse(null);
       int id = user.getId();
       Employe utilisateurEmploye = employeDao.findById(id).orElse(null);

        if(utilisateurEmploye == null) {
            utilisateurDao.deleteById(id);
            return "user deleted";
        }
       return "not deleted";
    }
}
