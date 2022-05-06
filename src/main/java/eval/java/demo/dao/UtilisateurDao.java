package eval.java.demo.dao;

import eval.java.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByLogin(String login);
    @Query("SELECT COUNT(u) FROM Utilisateur u")
    Integer compteUtilisateur();
}
