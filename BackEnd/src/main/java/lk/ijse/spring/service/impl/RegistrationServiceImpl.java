package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RegistrationDTO;
import lk.ijse.spring.service.RegistrationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public void saveRegistration(RegistrationDTO registrationDTO) {

    }

    @Override
    public void updateRegistration(RegistrationDTO registrationDTO) {

    }

    @Override
    public void deleteRegistration(String id) {

    }

    @Override
    public RegistrationDTO searchRegistration(String id) {
        return null;
    }

    @Override
    public List<RegistrationDTO> getAllRegistrations() {
        return null;
    }
}
