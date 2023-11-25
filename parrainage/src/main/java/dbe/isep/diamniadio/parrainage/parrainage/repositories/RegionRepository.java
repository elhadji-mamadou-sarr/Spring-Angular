package dbe.isep.diamniadio.parrainage.parrainage.repositories;

import dbe.isep.diamniadio.parrainage.parrainage.Model.Collecteur;
import dbe.isep.diamniadio.parrainage.parrainage.Model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
