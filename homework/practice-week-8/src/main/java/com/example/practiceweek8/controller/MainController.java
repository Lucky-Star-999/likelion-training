package com.example.practiceweek8.controller;

import com.example.practiceweek8.dto.DepartmentDto;
import com.example.practiceweek8.dto.EmployeeDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("likelion")
public class MainController {

    public EmployeeDto getEmployees(@RequestBody @Valid EmployeeDto employeeDto) {
        return null;
    }

    public DepartmentDto getDepartments(@RequestBody @Valid DepartmentDto departmentDto) {
        return null;
    }
}
