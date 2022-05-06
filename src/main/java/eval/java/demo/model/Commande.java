package eval.java.demo.model;

import com.fasterxml.jackson.annotation.JsonView;
import eval.java.demo.view.ViewUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Commande {

    public Commande() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(ViewUtilisateur.class)
    private Date datePaiement;

    @ManyToOne
    @JsonView(ViewUtilisateur.class)
    private Utilisateur client;

    @OneToMany(mappedBy = "commande")
    @JsonView(ViewUtilisateur.class)
    private List<LigneCommande> listeLigneCommande;
}
