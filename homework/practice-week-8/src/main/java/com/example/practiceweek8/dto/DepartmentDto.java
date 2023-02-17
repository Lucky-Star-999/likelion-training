package com.example.practiceweek8.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long departmentId;

    @NotEmpty(message = "Thiếu name")
    @Length(min = 10, max = 50)
    private String deptName;

    @NotEmpty(message = "Thiếu mô tả")
    private String description;

    @Valid
    private List<EmployeeDto> employeeDtoList;
}
