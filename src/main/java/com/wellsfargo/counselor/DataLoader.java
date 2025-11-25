package com.wellsfargo.counselor;

import com.wellsfargo.counselor.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final FinancialAdvisorRepository advisorRepo;
    private final ClientRepository clientRepo;
    private final PortfolioRepository portfolioRepo;
    private final SecurityRepository securityRepo;

    public DataLoader(FinancialAdvisorRepository advisorRepo,
                      ClientRepository clientRepo,
                      PortfolioRepository portfolioRepo,
                      SecurityRepository securityRepo) {

        this.advisorRepo = advisorRepo;
        this.clientRepo = clientRepo;
        this.portfolioRepo = portfolioRepo;
        this.securityRepo = securityRepo;
    }

    @Override
    public void run(String... args) {

        // Create advisor
        FinancialAdvisor advisor = new FinancialAdvisor("Alice Johnson");
        advisorRepo.save(advisor);

        // Create client
        Client client = new Client("Bob Smith", advisor);
        clientRepo.save(client);

        // Create portfolio
        Portfolio portfolio = new Portfolio(client);
        portfolioRepo.save(portfolio);

        // Create securities
        Security s1 = new Security("Apple Stock", "Equity", portfolio);
        Security s2 = new Security("Government Bond", "Fixed Income", portfolio);

        securityRepo.save(s1);
        securityRepo.save(s2);

        System.out.println("Sample data loaded successfully!");
    }
}
