package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String email;
    private String password;
    private int contactNo;
    private String nic;
    private String nicImage;
    private String licenseNo;
    private String licenseImage;
}
