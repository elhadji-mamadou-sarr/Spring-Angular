package dbe.isep.diamniadio.parrainage.parrainage.repositories;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Parrain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParrainRepository extends JpaRepository<Parrain, Long> {

    public Parrain findByNumElecteur(Integer numElecteur);

    List<Parrain> findAll(Specification<Parrain> specification);

    Page<Parrain> findAll(Specification<Parrain> specification, Pageable pageable);


}