package com.example.practiceweek8.controller;

import com.example.practiceweek8.dto.EmployeeDto;
import com.example.practiceweek8.service.EmployeeDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("likelion/employee")
public class EmployeeDtoController {

    @Autowired
    private EmployeeDtoService employeeDtoService;

    @PostMapping("/get")
    public EmployeeDto getEmployees(@RequestBody @Valid EmployeeDto employeeDto) {
        return employeeDtoService.getEmployeeDto(employeeDto);
    }
}
