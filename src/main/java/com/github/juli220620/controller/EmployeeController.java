package com.github.juli220620.controller;

import com.github.juli220620.model.dto.EmployeeDto;
import com.github.juli220620.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public long hireEmployee(@RequestBody EmployeeDto dto) {
        return service.hireEmployee(dto);
    }

    @PutMapping
    public void updateEmployee(@RequestBody EmployeeDto dto) {
        service.updateEmployee(dto);
    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployee(@PathVariable long id) {
        return service.getEmployeeById(id).orElseThrow();
    }

    @GetMapping("/company/{companyId}")
    public List<EmployeeDto> findEmployeesForCompany(@PathVariable long companyId) {
        return service.getAllEmployeesForCompany(companyId);
    }

    @DeleteMapping("/{id}")
    public void fireEmployee(@PathVariable long id) {
        service.fireEmployee(id);
    }

}
