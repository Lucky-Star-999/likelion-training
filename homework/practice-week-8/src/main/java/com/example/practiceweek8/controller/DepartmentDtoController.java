package com.example.practiceweek8.controller;

import com.example.practiceweek8.dto.DepartmentDto;
import com.example.practiceweek8.dto.EmployeeDto;
import com.example.practiceweek8.service.DepartmentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("likelion/department")
public class DepartmentDtoController {

    @Autowired
    private DepartmentDtoService departmentDtoService;

    @PostMapping("/get")
    public DepartmentDto getDepartments(@RequestBody @Valid DepartmentDto departmentDto) {
        return departmentDtoService.getDepartmentDto(departmentDto);
    }
}
