package dbe.isep.diamniadio.parrainage.parrainage.repositories;

import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppUserRepository extends JpaRepository<UserApp, Long> {
    @Query("SELECT u FROM UserApp u LEFT JOIN FETCH u.appRoles WHERE u.username = :username")
    UserApp findByUsername(String username);

    @Query("SELECT a FROM UserApp a where a.username=:username")
    UserApp findByLogin(String username);
}
