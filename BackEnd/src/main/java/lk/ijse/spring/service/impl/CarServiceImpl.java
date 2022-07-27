package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void saveCar(CarDTO carDTO) {
        if (!carRepo.existsById(carDTO.getCarNumber())) {
            carRepo.save(modelMapper.map(carDTO, Car.class));
        } else {
            throw new RuntimeException("Car Already Exist..!");
        }
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        if (carRepo.existsById(carDTO.getCarNumber())) {
            carRepo.save(modelMapper.map(carDTO,Car.class));
        } else {
            throw new RuntimeException("No Such Car To Update..! Please Check the ID..!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)){
            carRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Car ID.. No Such Car..!");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if (carRepo.existsById(id)){
            return modelMapper.map(carRepo.findById(id).get(), CarDTO.class);
        }else{
            throw new RuntimeException("No Car For "+id+" ..!");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<CarDTO>>(){
        }.getType());
    }
}
