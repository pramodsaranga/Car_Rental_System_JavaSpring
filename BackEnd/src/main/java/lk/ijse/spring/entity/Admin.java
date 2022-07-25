package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Admin {
    @Id
    private String username;
    private String email;
    private String password;
}
