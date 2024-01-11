package dbe.isep.diamniadio.parrainage.parrainage.securityApp;

import jakarta.persistence.*;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String roleName;




}
