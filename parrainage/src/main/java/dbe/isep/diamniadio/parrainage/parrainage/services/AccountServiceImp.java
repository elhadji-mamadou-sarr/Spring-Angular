package dbe.isep.diamniadio.parrainage.parrainage.services;

import dbe.isep.diamniadio.parrainage.parrainage.repositories.AppRoleRepository;
import dbe.isep.diamniadio.parrainage.parrainage.repositories.AppUserRepository;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.AppRole;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AccountServiceImp implements AccountService{

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public UserApp addNewUser(UserApp userApp) {
        String pwd = userApp.getPassword();
        userApp.setPassword(passwordEncoder().encode(pwd));
        return appUserRepository.save(userApp);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserApp userApp = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        userApp.getAppRoles().add(appRole);

    }

    @Override
    public UserApp loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public UserApp findByLogin(String username) {
       return appUserRepository.findByLogin(username);
    }

    @Override
    public List<UserApp> listUsers() {
        return appUserRepository.findAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
