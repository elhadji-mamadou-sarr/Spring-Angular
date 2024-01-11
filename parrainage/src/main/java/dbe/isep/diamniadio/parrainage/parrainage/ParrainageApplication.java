package dbe.isep.diamniadio.parrainage.parrainage;

import dbe.isep.diamniadio.parrainage.parrainage.securityApp.AppRole;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;
import dbe.isep.diamniadio.parrainage.parrainage.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class ParrainageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParrainageApplication.class, args);
	}

    /* @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));

            accountService.addNewUser(new UserApp(null, "user1", "1234", new ArrayList<>()));
            accountService.addNewUser(new UserApp(null, "admin", "1234", new ArrayList<>()));

            accountService.addRoleToUser("user1", "USER");
            accountService.addRoleToUser("admin", "ADMIN");
        };
    }*/


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                        .allowedOrigins("*");
            }
        };
    }


}
