package francis.janaj.maintenancerequestserver.domain.maintenanceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MaintenanceRequestTest {

    @Test
    public void constructorTest01(){
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest("Demo", "User", "demo@user.com", "1", "test");
        maintenanceRequest.setId(1L);
        LocalDate localDate = LocalDate.now();

        String expected = "1 Demo User demo@user.com 1 test";
        String actual = maintenanceRequest.toString();

        Assertions.assertEquals(expected,actual);

    }
}
