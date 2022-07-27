package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if (!adminRepo.existsById(adminDTO.getUsername())) {
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        } else {
            throw new RuntimeException("Admin Already Exist..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if (adminRepo.existsById(adminDTO.getUsername())) {
            adminRepo.save(modelMapper.map(adminDTO,Admin.class));
        } else {
            throw new RuntimeException("No Such Admin To Update..! Please Check the ID..!");
        }

    }

    @Override
    public void deleteAdmin(String id) {
        if (adminRepo.existsById(id)){
            adminRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Admin ID.. No Such Admin..!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (adminRepo.existsById(id)){
            return modelMapper.map(adminRepo.findById(id).get(), AdminDTO.class);
        }else{
            throw new RuntimeException("No Admin For "+id+" ..!");
        }
    }


    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> all = adminRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<AdminDTO>>(){
        }.getType());

    }
}
