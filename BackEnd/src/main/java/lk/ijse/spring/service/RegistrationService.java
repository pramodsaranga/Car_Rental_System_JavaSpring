package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationService {

    public void saveRegistration(RegistrationDTO registrationDTO);
    public void updateRegistration(RegistrationDTO registrationDTO);

    public void deleteRegistration(String id);

    public RegistrationDTO searchRegistration(String id);

    public List<RegistrationDTO> getAllRegistrations();
}
