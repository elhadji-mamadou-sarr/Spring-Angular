package dbe.isep.diamniadio.parrainage.parrainage.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Fiche {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private Long numero;
    @ManyToOne
    private Candidat candidat;

    @ManyToOne
    private DelegueRegional delegueRegional;

    @ManyToOne
    private Region region;

    @ManyToOne
    private Collecteur collecteur;

    @OneToMany(mappedBy = "fiche")
    private List<Parrain> parrains;

    public Fiche() {

    }

    public Fiche(Long id, Long numero, Candidat candidat, DelegueRegional delegueRegional, Region region, Collecteur collecteur) {
        this.id = id;
        this.numero = numero;
        this.candidat = candidat;
        this.delegueRegional = delegueRegional;
        this.region = region;
        this.collecteur = collecteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public DelegueRegional getDelegueRegional() {
        return delegueRegional;
    }

    public void setDelegueRegional(DelegueRegional delegueRegional) {
        this.delegueRegional = delegueRegional;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Collecteur getCollecteur() {
        return collecteur;
    }

    public void setCollecteur(Collecteur collecteur) {
        this.collecteur = collecteur;
    }

    public void setParrains(List<Parrain> parrains) {
        this.parrains = parrains;
    }

    public List<Parrain> getParrains() {
        return parrains;
    }


}
