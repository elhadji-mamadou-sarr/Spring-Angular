package dbe.isep.diamniadio.parrainage.parrainage.controller;

import dbe.isep.diamniadio.parrainage.parrainage.Model.DelegueRegional;
import dbe.isep.diamniadio.parrainage.parrainage.Model.Region;
import dbe.isep.diamniadio.parrainage.parrainage.services.DelegueRegionalService;
import dbe.isep.diamniadio.parrainage.parrainage.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> getDelegueRegionals(){
        return  regionService.getRegions();
    }

    @GetMapping("/{id}")
    public Region findRegion(@PathVariable Integer id){
        return regionService.findByRegion(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Integer id){
        regionService.deleteRegion(id);
    }

    @PostMapping
    public void createRegion(@RequestBody Region region){
        regionService.addRegion(region);
    }

    @PutMapping
    public void modifierRegion(@RequestBody Region region){
        regionService.editRegion(region);
    }
}
