package dbe.isep.diamniadio.parrainage.parrainage.securityApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity  @Data @AllArgsConstructor @NoArgsConstructor
public class UserApp  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Pour que le mot de passe ne s'affiche pas
    private String password;

    @ManyToMany
    private Collection<AppRole> appRoles;





}
