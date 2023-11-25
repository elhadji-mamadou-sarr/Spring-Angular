package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Collecteur;
import dbe.isep.diamniadio.parrainage.parrainage.Model.DelegueRegional;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.CollecteurRepository;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.DelegueRegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelegueRegionalService {

    @Autowired
    private DelegueRegionalRepository delegueRegionalRepository;

    public List<DelegueRegional> getDelegueRegional(){
        return delegueRegionalRepository.findAll();
    }

    public DelegueRegional findByDelegueRegional(Integer id){
        Optional<DelegueRegional> delegueRegional = delegueRegionalRepository.findById(id);
        return delegueRegional.orElse(null);
    }

    public void deleteDelegueRegional(Integer id){
        delegueRegionalRepository.deleteById(id);
    }

    public void addDelegueRegional(DelegueRegional delegueRegional){
        if (delegueRegional == null || delegueRegional.getId() == null) {
            throw new RuntimeException("L'id est obligatoire");
        }
        Optional<DelegueRegional> appTmt;
        appTmt = delegueRegionalRepository.findById(delegueRegional.getId());
        if (appTmt.isPresent()) {
            throw new RuntimeException("Ce delegue existe deja");
        }
       delegueRegionalRepository.save(delegueRegional);
    }

    public void editDelegueRegional(DelegueRegional delegueRegional) {
        if (delegueRegional == null || delegueRegional.getId() == null) {
            throw new RuntimeException("Le delegue doit avoir un identifiant");
        }
        delegueRegionalRepository.save(delegueRegional);
    }


}
