package com.teccience.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teccience.dto.EmployeeDto;
import com.teccience.entitiy.EmployeeEntity;
import com.teccience.exception.EmployeeIdNotFoundException;
import com.teccience.repository.EmployeeRepository;
import com.teccience.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper mapper;
    @Override
    public EmployeeDto addEmployee(EmployeeDto dto) {
        EmployeeEntity entity = mapper.convertValue(dto, EmployeeEntity.class);
        return mapper.convertValue(repository.save(entity), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getEmployeeList() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = repository.findAll();
        Iterator<EmployeeEntity> iterator = employeeEntityList.iterator();

        while (iterator.hasNext()){
            EmployeeDto dto = mapper.convertValue(iterator.next(), EmployeeDto.class);
            employeeDtoList.add(dto);
        }
        return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto dto) {
        EmployeeEntity entity = mapper.convertValue(dto, EmployeeEntity.class);
        return mapper.convertValue(repository.save(entity), EmployeeDto.class);
    }

    @Override
    public Integer deleteEmployee(Integer id) {
        if (repository.findById(id).isEmpty()){
            throw new EmployeeIdNotFoundException(id);
        }
        repository.deleteById(id);
        return id;
    }
}
