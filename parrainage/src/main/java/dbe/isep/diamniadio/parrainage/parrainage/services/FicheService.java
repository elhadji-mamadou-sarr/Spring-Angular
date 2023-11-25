package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Fiche;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.FicheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
