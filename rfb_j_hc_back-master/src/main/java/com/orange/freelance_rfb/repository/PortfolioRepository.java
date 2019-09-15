package com.orange.freelance_rfb.repository;

import com.orange.freelance_rfb.model.entity.Account;
import com.orange.freelance_rfb.model.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository
        extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByAccount(Account account);
}
