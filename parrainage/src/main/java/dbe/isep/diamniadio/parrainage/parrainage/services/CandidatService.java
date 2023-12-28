package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Candidat;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    public List<Candidat> findAllCandidats(){
        return candidatRepository.findAll();
    }

    public Candidat findByCandidat(Integer id){
        Optional<Candidat> candidat = candidatRepository.findById(id);
        return candidat.orElse(null);
    }

    public Candidat addCandidat(Candidat candidat){
        Optional<Candidat> c = candidatRepository.findById(candidat.getId());
        if (!c.isPresent()) {
            return candidatRepository.save(candidat);
        }else
            throw new RuntimeException("Ce candidat  existe  déjà");
    }

    public void deleteByCandidat(Integer id){
        candidatRepository.deleteById(id);
    }

    public Candidat editCandidat(Candidat candidat){
        Candidat existant = candidat;
        if (existant.getId() != null) {
            existant.setNom(candidat.getNom());
            return candidatRepository.save(existant);
        }else
            throw new RuntimeException("Ce candidat n'existe pas");
    }

}
