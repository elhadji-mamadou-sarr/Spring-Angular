package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Collecteur;
import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.CollecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollecteurService {

    @Autowired
    private CollecteurRepository collecteurRepository;

    public List<Collecteur> getCollecteurs(){
        return collecteurRepository.findAll();
    }

    public Collecteur findByCollecteur(Integer id){
        Optional<Collecteur> collecteurOptional = collecteurRepository.findById(id);
        return collecteurOptional.orElse(null);
    }

    public void deleteCollecteur(Integer id){
        collecteurRepository.deleteById(id);
    }

    public void addCollecteur(Collecteur collecteur){
        if (collecteur == null || collecteur.getId() == null) {
            throw new RuntimeException("L'id est obligatoire");
        }
        Optional<Collecteur> appTmt;
        appTmt = collecteurRepository.findById(collecteur.getId());
        if (appTmt.isPresent()) {
            throw new RuntimeException("Ce collecteur existe deja");
        }
       collecteurRepository.save(collecteur);
    }

    public void editCollecteur(Collecteur collecteur) {
        if (collecteur == null || collecteur.getId() == null) {
            throw new RuntimeException("Le collecteur doit avoir un identifiant");
        }
        collecteurRepository.save(collecteur);
    }


}
