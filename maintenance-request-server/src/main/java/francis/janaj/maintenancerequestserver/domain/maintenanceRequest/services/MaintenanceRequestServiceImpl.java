package francis.janaj.maintenancerequestserver.domain.maintenanceRequest.services;

import francis.janaj.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import francis.janaj.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import francis.janaj.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import francis.janaj.maintenancerequestserver.domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService{
    private MaintenanceRequestRepo maintenanceRequestRepo;
    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo) {
        this.maintenanceRequestRepo = maintenanceRequestRepo;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
        if(optional.isPresent()){
            throw new ResourceCreationException("Maintenance Request with email exists: " + maintenanceRequest.getEmail());
        }

        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Maintenance Request with id: " + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No Maintenance Request with email: " + email));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
        maintenanceRequest.setLastName(maintenanceRequest.getLastName());
        maintenanceRequest.setEmail(maintenanceRequest.getEmail());
        maintenanceRequest.setAptNumber(maintenanceRequest.getAptNumber());
        maintenanceRequest.setDescription(maintenanceRequestDetail.getDescription());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.getById(id);
        maintenanceRequestRepo.delete(maintenanceRequest);

    }
}
