package eval.java.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import eval.java.demo.dao.CommandeDao;
import eval.java.demo.dao.EmployeDao;
import eval.java.demo.dao.UtilisateurDao;
import eval.java.demo.model.Commande;
import eval.java.demo.view.ViewUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {
    CommandeDao commandeDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }


    @GetMapping("/liste-commande")
    @JsonView(ViewUtilisateur.class)
    public List<Commande> commandes() {
        List<Commande> commande = this.commandeDao.findAll();
        return commande;
    }
}
