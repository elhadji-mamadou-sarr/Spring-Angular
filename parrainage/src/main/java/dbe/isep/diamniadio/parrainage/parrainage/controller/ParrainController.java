package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Fiche;
import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;
import dbe.isep.diamniadio.parrainage.parrainage.services.ParrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parrainages")
public class ParrainController {

    @Autowired
    private ParrainService parrainServiceService;
    @GetMapping
    public List<Parrain> getParrains(){
        return  parrainServiceService.getParrains();
    }

    @GetMapping("/paged")
    public Page<Parrain> getPagedParrains(@RequestParam int page, @RequestParam int size) {
        return parrainServiceService.getParrainsPage(page, size);
    }

    @GetMapping("/{id}")
    public Parrain findApprenant(@PathVariable Long id){
        return parrainServiceService.finParrain(id);
    }

    @DeleteMapping("/{id}")
    public void deleteApprenant(@PathVariable Long id){
        parrainServiceService.deleteParrain(id);
    }

    @PostMapping
    public void createApprenant(@RequestBody Parrain app, UserApp userApp){
        parrainServiceService.addParrain(app, userApp);
    }

    @PutMapping
    public void modifierApp(@RequestBody Parrain parrain){
        parrainServiceService.editParrain(parrain);
    }

    @GetMapping("/search")
    public Page<Parrain> searchParrains( @RequestParam String searchTerm,
                                         @RequestParam int page, @RequestParam int size) {
        return parrainServiceService.searchParrains(searchTerm, page, size);
    }



}
