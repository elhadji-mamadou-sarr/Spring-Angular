package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.ParrainRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParrainService {

    @Autowired
    private ParrainRepository parrainRepository;

    public List<Parrain> getParrains(){
        return parrainRepository.findAll();
    }

    public Parrain finParrain(Long id){
        Optional<Parrain>  parrainOptional = parrainRepository.findById(id);

        return parrainOptional.orElse(null);
    }

    public void deleteParrain(Long id){
        parrainRepository.deleteById(id);
    }

    public void addParrain(Parrain app){
        if (app == null || app.getId() == null) {
            throw new RuntimeException("L'id est obligatoire");
        }
        Optional<Parrain> appTmt;
        appTmt = parrainRepository.findById(app.getId());
        if (appTmt.isPresent()) {
            throw new RuntimeException("Le parrain existe deja");
        }
        parrainRepository.save(app);
    }

    public void editParrain( Parrain updatedParrain) {
        if (updatedParrain == null || updatedParrain.getId() == null) {
            throw new RuntimeException("Le delegue doit avoir un identifiant");
        }
        parrainRepository.save(updatedParrain);
    }



}
