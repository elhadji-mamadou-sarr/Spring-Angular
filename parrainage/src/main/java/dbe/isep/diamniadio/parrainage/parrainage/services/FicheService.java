package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Fiche;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.FicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FicheService {

    @Autowired
    private FicheRepository ficheRepository;


    public List<Fiche> findAllFiches(){
        return ficheRepository.findAll();
    }

    public Fiche findFicheByNumero(Long numero){
        return ficheRepository.findByNumero(numero);
    }

    public Fiche findFicheById(Long id){
        Optional<Fiche> fiche = ficheRepository.findById(id);
        return fiche.orElse(null);
    }






}
