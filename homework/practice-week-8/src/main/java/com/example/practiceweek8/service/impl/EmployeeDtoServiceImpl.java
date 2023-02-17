package com.example.practiceweek8.service.impl;

import com.example.practiceweek8.dto.EmployeeDto;
import com.example.practiceweek8.service.EmployeeDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDtoServiceImpl implements EmployeeDtoService {
    private Logger logger = LoggerFactory.getLogger(EmployeeDtoServiceImpl.class);

    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto employeeDto) {
        logger.info(employeeDto.toString());
        return employeeDto;
    }
}
