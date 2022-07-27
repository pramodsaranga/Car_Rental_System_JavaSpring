package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RegistrationDTO;
import lk.ijse.spring.entity.Registration;
import lk.ijse.spring.repo.RegistrationRepo;
import lk.ijse.spring.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveRegistration(RegistrationDTO registrationDTO) {
        if (!registrationRepo.existsById(registrationDTO.getRegistrationId())) {
            registrationRepo.save(modelMapper.map(registrationDTO, Registration.class));
        } else {
            throw new RuntimeException("Registration Already Exist..!");
        }
    }

    @Override
    public void updateRegistration(RegistrationDTO registrationDTO) {
        if (registrationRepo.existsById(registrationDTO.getRegistrationId())) {
            registrationRepo.save(modelMapper.map(registrationDTO,Registration.class));
        } else {
            throw new RuntimeException("No Such Registration To Update..! Please Check the ID..!");
        }
    }

    @Override
    public void deleteRegistration(String id) {
        if (registrationRepo.existsById(id)){
            registrationRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Registration ID.. No Such Registration..!");
        }
    }

    @Override
    public RegistrationDTO searchRegistration(String id) {
        if (registrationRepo.existsById(id)){
            return modelMapper.map(registrationRepo.findById(id).get(), RegistrationDTO.class);
        }else{
            throw new RuntimeException("No Registration For "+id+" ..!");
        }
    }

    @Override
    public List<RegistrationDTO> getAllRegistrations() {
        List<Registration> all = registrationRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<RegistrationDTO>>(){
        }.getType());
    }
}
