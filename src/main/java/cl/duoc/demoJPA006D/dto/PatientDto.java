package cl.duoc.demoJPA006D.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    Long id;
    String name;
    String lastName;
    String phone;
}
