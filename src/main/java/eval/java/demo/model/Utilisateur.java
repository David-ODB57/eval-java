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
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    public Utilisateur() {
    }

    public Utilisateur(String login) {
        this.login = login;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ViewUtilisateur.class, ViewEmploye.class})
    private Integer id;

    @JsonView({ViewUtilisateur.class, ViewEmploye.class})
    private String login;

    private String password;

    @OneToMany(mappedBy = "client")
    @JsonView(ViewEmploye.class)
    private List<Commande> listeCommande;

    @ManyToMany
    private List<MoyenPaiement> listeMoyenPaiement;
}
