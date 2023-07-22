package francis.janaj.maintenancerequestserver.domain.maintenanceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity // JPA to save to the database
@NoArgsConstructor // Generate non argument constructor
@RequiredArgsConstructor // Generate parameterized constructor
@Data // Generate getters and setters
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String aptNumber;
    @NonNull
    private String description;
    @CreationTimestamp
    private LocalDate Date;
    public String toString(){
        return String.format("%d %s %s %s %s %s", id, firstName, lastName, email, aptNumber,description);
    }


}
