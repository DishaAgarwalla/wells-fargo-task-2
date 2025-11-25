package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.Security;
import com.wellsfargo.counselor.repository.SecurityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/securities")
public class SecurityController {

    private final SecurityRepository securityRepository;

    public SecurityController(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @GetMapping
    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    @PostMapping
    public Security createSecurity(@RequestBody Security security) {
        return securityRepository.save(security);
    }

    @GetMapping("/{id}")
    public Security getSecurity(@PathVariable Long id) {
        return securityRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSecurity(@PathVariable Long id) {
        securityRepository.deleteById(id);
    }
}
