package com.teccience.controller;

import com.teccience.dto.EmployeeDto;
import com.teccience.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @PostMapping
    ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto){
        return new ResponseEntity<>(service.addEmployee(dto), HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<EmployeeDto>> getEmployeeList(){
        return new ResponseEntity<>(service.getEmployeeList(), HttpStatus.OK);
    }
    @PutMapping
    ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto){
        return new ResponseEntity<>(service.updateEmployee(dto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        Integer deletedId = service.deleteEmployee(id);
        return new ResponseEntity<>("Item("+deletedId+") has been deleted successfully!", HttpStatus.OK);
    }
}
