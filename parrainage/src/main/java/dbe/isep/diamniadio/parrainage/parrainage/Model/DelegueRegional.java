package dbe.isep.diamniadio.parrainage.parrainage.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DelegueRegional {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private Integer numElecteur;

    public DelegueRegional(Integer id, String nom, String prenom, Integer numElecteur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numElecteur = numElecteur;
    }

    public DelegueRegional() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getNumElecteur() {
        return numElecteur;
    }

    public void setNumElecteur(Integer numElecteur) {
        this.numElecteur = numElecteur;
    }
}
