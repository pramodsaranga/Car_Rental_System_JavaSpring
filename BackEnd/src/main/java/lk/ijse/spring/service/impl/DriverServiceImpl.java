package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Override
    public void saveDriver(DriverDTO driverDTO) {

    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public DriverDTO searchDriver(String id) {
        return null;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return null;
    }
}
