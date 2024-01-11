
package dbe.isep.diamniadio.parrainage.parrainage.services;


import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.AppUserRepository;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.ParrainRepository;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class ParrainService {

    @Autowired
    private ParrainRepository parrainRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Parrain> getParrains(){
        return parrainRepository.findAll();
    }

    public Page<Parrain> getParrainsPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return parrainRepository.findAll(pageRequest);
    }

    public Parrain finParrain(Long id){
        Optional<Parrain>  parrainOptional = parrainRepository.findById(id);

        return parrainOptional.orElse(null);
    }

    public void deleteParrain(Long id){
        parrainRepository.deleteById(id);
    }


    public void addParrain(Parrain app, UserApp userApp){
        if (app == null || app.getId() == null) {
            throw new RuntimeException("L'id est obligatoire");
        }
        Optional<Parrain> appTmt;
        appTmt = parrainRepository.findById(app.getId());
        if (appTmt.isPresent()) {
            throw new RuntimeException("Le parrain existe deja");
        }
        String pwd = userApp.getPassword();
        userApp.setPassword(passwordEncoder.encode(pwd));
         appUserRepository.save(userApp);
        parrainRepository.save(app);
    }

    public void editParrain(Parrain updatedParrain ) {
        if (updatedParrain == null || updatedParrain.getId() == null) {
            throw new RuntimeException("Le delegue doit avoir un identifiant");
        }
        parrainRepository.save(updatedParrain);
    }


    public Page<Parrain> searchParrains(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return parrainRepository.findAll((Specification<Parrain>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(searchTerm)) {
                String searchPattern = "%" + searchTerm.toLowerCase() + "%";

                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("nom")), searchPattern),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("prenom")), searchPattern),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("localite")), searchPattern)
                ));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }





}