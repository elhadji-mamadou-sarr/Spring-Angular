package dbe.isep.diamniadio.parrainage.parrainage.repositories;

import dbe.isep.diamniadio.parrainage.parrainage.securityApp.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    @Query("SELECT a FROM AppRole a where a.roleName=:roleName")
    AppRole findByRoleName(String roleName);
}
