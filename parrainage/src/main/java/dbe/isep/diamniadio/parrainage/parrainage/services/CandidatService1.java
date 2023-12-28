package dbe.isep.diamniadio.parrainage.parrainage.services;

import org.springframework.stereotype.Service;

@Service
public class CandidatService1 {
 /*   @Autowired
    private CandidatRepository candidatRepository;

    public List<Candidat> findAllCandidats(){
        return candidatRepository.findAll();
    }

    public Candidat findByCandidat(Integer id){
        Optional<Candidat> candidat = candidatRepository.findById(id);
        return candidat.orElse(null);
    }

    public Candidat addCandidat(Candidat candidat){
       Optional<Candidat> c = candidatRepository.findById(candidat.getId());
        if (!c.isPresent()) {
            return candidatRepository.save(candidat);
        }else
            throw new RuntimeException("Ce candidat  existe  déjà");
    }

    public void deleteByCandidat(Integer id){
        candidatRepository.deleteById(id);
    }

    public Candidat editCandidat(Candidat candidat){
        Candidat existant = candidat;
        if (existant.getId() != null) {
            existant.setNom(candidat.getNom());
            return candidatRepository.save(existant);
        }else
        throw new RuntimeException("Ce candidat n'existe pas");
    }
*/


}
