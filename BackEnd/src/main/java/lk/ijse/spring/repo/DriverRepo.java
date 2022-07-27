package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver,String> {
    Optional<Driver> findByName(String name);

    Optional<Driver> findByEmailAndPassword(String email, String password);
}
