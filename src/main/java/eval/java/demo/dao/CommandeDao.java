package eval.java.demo.dao;

import eval.java.demo.model.Article;
import eval.java.demo.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {
}
