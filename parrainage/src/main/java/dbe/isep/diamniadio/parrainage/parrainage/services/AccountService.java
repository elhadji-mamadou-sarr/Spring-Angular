package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.securityApp.AppRole;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;

import java.util.List;

public interface AccountService {

    AppRole addNewRole(AppRole appRole);

    UserApp addNewUser(UserApp userApp);

    void addRoleToUser(String username, String roleName);

    UserApp loadUserByUsername(String username);

    UserApp findByLogin(String username);

    List<UserApp> listUsers();

}
