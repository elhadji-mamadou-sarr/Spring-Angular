package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Collecteur;
import dbe.isep.diamniadio.parrainage.parrainage.Model.DelegueRegional;
import dbe.isep.diamniadio.parrainage.parrainage.services.CollecteurService;
import dbe.isep.diamniadio.parrainage.parrainage.services.DelegueRegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deleguers")
public class DelegueController {

    @Autowired
    private DelegueRegionalService delegueRegionalService;

    @GetMapping
    public List<DelegueRegional> getDelegueRegionals(){
        return  delegueRegionalService.getDelegueRegional();
    }

    @GetMapping("/{id}")
    public DelegueRegional findDelegueRegional(@PathVariable Integer id){
        return delegueRegionalService.findByDelegueRegional(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDelegueRegional(@PathVariable Integer id){
        delegueRegionalService.deleteDelegueRegional(id);
    }

    @PostMapping
    public void createDelegueRegional(@RequestBody DelegueRegional delegueRegional){
        delegueRegionalService.addDelegueRegional(delegueRegional);
    }

    @PutMapping
    public void modifierDelegueRegional(@RequestBody DelegueRegional delegueRegional){
        delegueRegionalService.editDelegueRegional(delegueRegional);
    }
}
