package eval.java.demo.model;

import com.fasterxml.jackson.annotation.JsonView;
import eval.java.demo.view.ViewEmploye;
import eval.java.demo.view.ViewUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Employe extends Utilisateur {

    public Employe() {
    }

    private Boolean administrateur;

    @OneToMany(mappedBy = "gestionnaire")
    @JsonView({ViewUtilisateur.class, ViewEmploye.class})
    private List<Article> listeArticleAgerer;
}
