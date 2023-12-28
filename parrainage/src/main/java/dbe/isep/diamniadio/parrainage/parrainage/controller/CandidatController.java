package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Candidat;
import dbe.isep.diamniadio.parrainage.parrainage.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @GetMapping
    public List<Candidat> candidats(){
        return candidatService.findAllCandidats();
    }

    @GetMapping("/{id}")
    public Candidat candidatById(@PathVariable Integer id){
        return candidatService.findByCandidat(id);
    }

    @PostMapping
    public Candidat posCandidat(@RequestBody Candidat candidat){
        return candidatService.addCandidat(candidat);
    }

    @PutMapping
    public Candidat putCandidat(@RequestBody Candidat candidat){
        return candidatService.editCandidat(candidat);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidat(@PathVariable Integer id){
        candidatService.deleteByCandidat(id);
    }
}
