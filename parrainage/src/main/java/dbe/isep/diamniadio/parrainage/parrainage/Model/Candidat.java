package dbe.isep.diamniadio.parrainage.parrainage.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Candidat {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String party;

    @OneToMany
    private List<Fiche> fiches;

    public Candidat(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Candidat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getParty() {
        return party;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    public List<Fiche> getFiches() {
        return fiches;
    }


}
