package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
