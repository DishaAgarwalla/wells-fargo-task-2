package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    private final PortfolioRepository portfolioRepository;

    public PortfolioController(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @GetMapping("/{id}")
    public Portfolio getPortfolio(@PathVariable Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioRepository.deleteById(id);
    }
}
