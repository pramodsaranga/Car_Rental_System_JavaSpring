package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;

import java.util.List;

public interface AdminService {

    public void saveAdmin(AdminDTO adminDTO);
    public void updateAdmin(AdminDTO adminDTO);

    public void deleteAdmin(String id);

    public AdminDTO searchAdmin(String id);

    public List<AdminDTO> getAllAdmins();
}
