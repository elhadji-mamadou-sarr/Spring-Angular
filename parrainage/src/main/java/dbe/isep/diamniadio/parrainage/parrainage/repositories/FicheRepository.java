package dbe.isep.diamniadio.parrainage.parrainage.repositories;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FicheRepository extends JpaRepository<Fiche, Long> {

    @Query("SELECT a FROM Fiche a where a.numero=:numero")
    Fiche findByNumero(Long numero);


}
