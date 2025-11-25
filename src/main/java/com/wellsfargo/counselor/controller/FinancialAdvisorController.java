package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.FinancialAdvisor;
import com.wellsfargo.counselor.repository.FinancialAdvisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisors")
public class FinancialAdvisorController {

    private final FinancialAdvisorRepository advisorRepository;

    public FinancialAdvisorController(FinancialAdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    @GetMapping
    public List<FinancialAdvisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    @PostMapping
    public FinancialAdvisor createAdvisor(@RequestBody FinancialAdvisor advisor) {
        return advisorRepository.save(advisor);
    }

    @GetMapping("/{id}")
    public FinancialAdvisor getAdvisor(@PathVariable Long id) {
        return advisorRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable Long id) {
        advisorRepository.deleteById(id);
    }
}
