package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Fiche;
import dbe.isep.diamniadio.parrainage.parrainage.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fiches")
public class FicheController {

    @Autowired
    private FicheService ficheService;

    @GetMapping
    public List<Fiche> fiches(){
        return ficheService.findAllFiches();
    }

    @GetMapping("/{numero}")
    public Fiche ficheByNum(@PathVariable Long numero){
        return ficheService.findFicheByNumero(numero);
    }

}
