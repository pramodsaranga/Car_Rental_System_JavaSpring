package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getEmail())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getEmail())) {
            customerRepo.save(modelMapper.map(customerDTO,Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerRepo.existsById(id)){
            return modelMapper.map(customerRepo.findById(id).get(), CustomerDTO.class);
        }else{
            throw new RuntimeException("No Customer For "+id+" ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<CustomerDTO>>(){
        }.getType());

    }

    @Override
    public CustomerDTO findEmailAndPassword(String email, String password) {
        Optional<Customer> cus = customerRepo.findByEmailAndPassword(email, password);
        if (cus.isPresent()) {
            return modelMapper.map(cus.get(), CustomerDTO.class);
        }
        throw new RuntimeException("Email name and Password Not Matched");
    }

    @Override
    public boolean findUser(String email) {
        boolean isAvailable = customerRepo.existsByEmail(email);
        if (customerRepo.existsById(email)) {
            customerRepo.save(modelMapper.map(email, Customer.class));
            System.out.println(isAvailable+"");
            return true;
        }
        return false;
    }

    @Override
    public CustomerDTO findNic(String nic) {
        Optional<Customer> registration = customerRepo.findByNic(nic);
        if (registration.isPresent()) {
            return modelMapper.map(registration.get(), CustomerDTO.class);
        }
        throw new RuntimeException("NIC Not Matched");
    }
}
