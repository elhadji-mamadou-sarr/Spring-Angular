package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Collecteur;
import dbe.isep.diamniadio.parrainage.parrainage.Model.Region;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.CollecteurRepository;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegions(){
        return regionRepository.findAll();
    }

    public Region findByRegion(Integer id){
        Optional<Region> collecteurOptional = regionRepository.findById(id);
        return collecteurOptional.orElse(null);
    }

    public void deleteRegion(Integer id){
        regionRepository.deleteById(id);
    }

    public void addRegion(Region region){
        if (region == null || region.getId() == null) {
            throw new RuntimeException("L'id est obligatoire");
        }
        Optional<Region> appTmt;
        appTmt = regionRepository.findById(region.getId());
        if (appTmt.isPresent()) {
            throw new RuntimeException("Cette region existe deja");
        }
       regionRepository.save(region);
    }

    public void editRegion(Region region) {
        if (region == null || region.getId() == null) {
            throw new RuntimeException("La region doit avoir un identifiant");
        }
        regionRepository.save(region);
    }


}
