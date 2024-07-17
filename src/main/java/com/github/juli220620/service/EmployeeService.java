package com.github.juli220620.service;

import com.github.juli220620.model.dto.EmployeeDto;
import com.github.juli220620.repo.CompanyRepo;
import com.github.juli220620.repo.EmployeeRepo;
import com.github.juli220620.utils.EmployeeAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final CompanyRepo companyRepo;
    private final EmployeeAssembler assembler;

    public long hireEmployee(EmployeeDto data) {
        return employeeRepo.save(assembler.assemble(data)).getId();
    }

    public void updateEmployee(EmployeeDto data) {
        var entity = employeeRepo.findById(data.getId()).orElseThrow();
        assembler.assemble(entity, data);
        employeeRepo.save(entity);
    }

    public Optional<EmployeeDto> getEmployeeById(long id) {
        return employeeRepo.findById(id).map(assembler::disassemble);
    }

    public void fireEmployee(long id) {
        employeeRepo.deleteById(id);
    }

    public List<EmployeeDto> getAllEmployeesForCompany(long companyId) {
        return companyRepo.findById(companyId)
                .map(it -> it.getEmployees().stream()
                        .map(assembler::disassemble)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

    }
}
