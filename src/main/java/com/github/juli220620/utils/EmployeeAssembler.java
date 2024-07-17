package com.github.juli220620.utils;

import com.github.juli220620.model.EmployeeEntity;
import com.github.juli220620.model.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAssembler {

    public EmployeeEntity assemble(EmployeeEntity entity, EmployeeDto data) {
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setDepartment(data.getDepartment());
        entity.setCompanyId(data.getCompanyId());
        entity.setSalary(data.getSalary());

        return entity;
    }

    public EmployeeEntity assemble(EmployeeDto data) {
        return assemble(new EmployeeEntity(), data);
    }

    public EmployeeDto disassemble(EmployeeEntity entity) {
        var data = new EmployeeDto();

        data.setId(entity.getId());
        data.setName(entity.getName());
        data.setDepartment(entity.getDepartment());
        data.setSalary(entity.getSalary());
        data.setCompanyId(entity.getCompanyId());

        return data;
    }
}
