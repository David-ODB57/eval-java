package eval.java.demo.dao;

import eval.java.demo.model.Employe;
import eval.java.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Integer> {

//    Optional<Utilisateur> findByLogin(String login);

    @Query("SELECT COUNT(*) FROM Employe e WHERE e.administrateur=1")
    Integer compteAdministrateur();
}
