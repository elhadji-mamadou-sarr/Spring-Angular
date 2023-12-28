package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Fiche;
import dbe.isep.diamniadio.parrainage.parrainage.services.FicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id/{id}")
    public Fiche ficheById(@PathVariable Long id){
        return ficheService.findFicheById(id);
    }



}
