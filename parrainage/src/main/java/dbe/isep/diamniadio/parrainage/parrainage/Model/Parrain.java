package dbe.isep.diamniadio.parrainage.parrainage.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Parrain {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Integer numElecteur;
    private Long numIdentite;
    private String localite;
    private Date dateSignature;
    @ManyToOne
    private Fiche fiche;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getNumIdentite() {
        return numIdentite;
    }

    public void setNumIdentite(Long numIdentite) {
        this.numIdentite = numIdentite;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public Parrain(Long id, String nom, String prenom, Integer numElecteur, Long numIdentite, String localite, Date dateSignature) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numElecteur = numElecteur;
        this.numIdentite = numIdentite;
        this.localite = localite;
        this.dateSignature = dateSignature;
    }

    public Parrain() {
    }


}
