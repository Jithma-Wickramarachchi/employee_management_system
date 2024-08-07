package com.teccience.service;

import com.teccience.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto dto);

    List<EmployeeDto> getEmployeeList();

    EmployeeDto updateEmployee(EmployeeDto dto);

    Integer deleteEmployee(Integer id);
}
