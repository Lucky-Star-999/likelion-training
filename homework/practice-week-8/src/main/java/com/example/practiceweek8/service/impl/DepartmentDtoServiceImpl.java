package com.example.practiceweek8.service.impl;

import com.example.practiceweek8.dto.DepartmentDto;
import com.example.practiceweek8.service.DepartmentDtoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDtoServiceImpl implements DepartmentDtoService {
    private Logger logger = LoggerFactory.getLogger(DepartmentDtoServiceImpl.class);

    @Override
    public DepartmentDto getDepartmentDto(DepartmentDto departmentDto) {
        logger.info(departmentDto.toString());
        return departmentDto;
    }
}
