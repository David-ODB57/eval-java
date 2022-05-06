package eval.java.demo.model;

import com.fasterxml.jackson.annotation.JsonView;
import eval.java.demo.view.ViewUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class LigneCommande {

    public LigneCommande() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(ViewUtilisateur.class)
    private Integer quantite;

    @ManyToOne
    private Commande commande;

    @ManyToOne
    @JsonView(ViewUtilisateur.class)
    private Article article;
}
