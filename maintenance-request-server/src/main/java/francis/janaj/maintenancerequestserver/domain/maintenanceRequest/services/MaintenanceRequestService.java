package francis.janaj.maintenancerequestserver.domain.maintenanceRequest.services;

import francis.janaj.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import francis.janaj.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import francis.janaj.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {

    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
