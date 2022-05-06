package eval.java.demo.model;


import com.fasterxml.jackson.annotation.JsonView;
import eval.java.demo.view.ViewEmploye;
import eval.java.demo.view.ViewUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView({ViewUtilisateur.class, ViewEmploye.class})
    private String nom;

    @JsonView(ViewUtilisateur.class)
    private Float prix;

    @ManyToOne
    private Employe gestionnaire;

}
