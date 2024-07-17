package com.github.juli220620.service;

import com.github.juli220620.model.dto.CompanyDto;
import com.github.juli220620.repo.CompanyRepo;
import com.github.juli220620.utils.CompanyAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepo repo;
    private final CompanyAssembler assembler;

    public long addCompany(CompanyDto data) {
        return repo.save(assembler.assemble(data)).getId();
    }

    public void updateCompany(CompanyDto data) {
        var entity = repo.findById(data.getId()).orElseThrow();
        assembler.assemble(entity, data);
        repo.save(entity);
    }

    public Optional<CompanyDto> getCompanyById(long id) {
        return repo.findById(id).map(assembler::disassemble);
    }

    public void deleteCompany(long id) {
        repo.deleteById(id);
    }

    public List<CompanyDto> getAll() {
        return repo.findAll().stream()
                .map(assembler::disassemble)
                .collect(Collectors.toList());
    }
}
