package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Collecteur;
import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import dbe.isep.diamniadio.parrainage.parrainage.services.CollecteurService;
import dbe.isep.diamniadio.parrainage.parrainage.services.ParrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collecteurs")
public class CollecteurController {

    @Autowired
    private CollecteurService collecteurService;
    @GetMapping
    @CrossOrigin("http://localhost:4200")
    public List<Collecteur> getCollecteurs(){
        return  collecteurService.getCollecteurs();
    }

    @GetMapping("/{id}")
    public Collecteur findCollecteur(@PathVariable Integer id){
        return collecteurService.findByCollecteur(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCollecteur(@PathVariable Integer id){
        collecteurService.deleteCollecteur(id);
    }

    @PostMapping
    public void createCollecteur(@RequestBody Collecteur collecteur){
        collecteurService.addCollecteur(collecteur);
    }

    @PutMapping
    public void modifierCollecteur(@RequestBody Collecteur collecteur){
        collecteurService.editCollecteur(collecteur);
    }
}
