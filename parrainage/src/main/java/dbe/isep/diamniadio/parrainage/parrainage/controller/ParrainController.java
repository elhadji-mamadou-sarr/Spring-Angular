package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import dbe.isep.diamniadio.parrainage.parrainage.services.ParrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parrainages")
public class ParrainController {

    @Autowired
    private ParrainService parrainServiceService;
    @GetMapping
   // @CrossOrigin("http://localhost:4200")
    public List<Parrain> getParrains(){
        return  parrainServiceService.getParrains();
    }

    @GetMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public Parrain findApprenant(@PathVariable Long id){
        return parrainServiceService.finParrain(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public void deleteApprenant(@PathVariable Long id){
        parrainServiceService.deleteParrain(id);
    }

    @PostMapping
    @CrossOrigin("http://localhost:4200")
    public void createApprenant(@RequestBody Parrain app){
        parrainServiceService.addParrain(app);
    }

    @PutMapping
   // @CrossOrigin("http://localhost:4200")
    public void modifierApp(@RequestBody Parrain parrain){
        parrainServiceService.editParrain(parrain);
    }


}
