package francis.janaj.maintenancerequestserver.domain.maintenanceRequest.repos;

import francis.janaj.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRequestRepo extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);
}
