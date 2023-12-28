package dbe.isep.diamniadio.parrainage.parrainage.Model;

import jakarta.persistence.*;

import java.util.List;


public class Candidat1 {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String party;
    @OneToMany(mappedBy = "candidat")
    private List<Fiche> fiches;

    public Candidat1(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Candidat1() {
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