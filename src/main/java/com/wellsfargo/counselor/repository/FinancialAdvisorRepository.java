package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.FinancialAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialAdvisorRepository extends JpaRepository<FinancialAdvisor, Long> {
}
