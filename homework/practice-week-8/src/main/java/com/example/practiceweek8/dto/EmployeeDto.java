package com.example.practiceweek8.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Long employeeId;

    @NotEmpty(message = "Thiếu name")
    @Length(min = 10, max = 50)
    private String name;

    private Date birthDate;

    private String gender;

    @NotEmpty(message = "Thiếu email")
    @Email(message = "Email chưa đúng format")
    private String email;
}
