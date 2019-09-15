package com.orange.freelance_rfb.service;

import com.orange.freelance_rfb.model.dto.PortfolioDto;
import com.orange.freelance_rfb.model.entity.Portfolio;
import com.orange.freelance_rfb.repository.AccountRepository;
import com.orange.freelance_rfb.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {
    private final AccountRepository accountRepository;
    private final PortfolioRepository portfolioRepository;

    public PortfolioService(AccountRepository accountRepository, PortfolioRepository portfolioRepository) {
        this.accountRepository = accountRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public void add(String login, String info) {
        Portfolio portfolio = Portfolio
                .builder()
                .account(accountRepository.findByLogin(login))
                .info(info)
                .build();
        portfolioRepository.save(portfolio);
    }

    public List<PortfolioDto> findByLogin(String login) {
        List<PortfolioDto> portfolioDtos = new ArrayList<>();
        List<Portfolio> portfolios = portfolioRepository.findByAccount(accountRepository.findByLogin(login));
        for (Portfolio p : portfolios) {
            portfolioDtos.add(PortfolioDto
                    .builder()
                    .login(login)
                    .info(p.getInfo())
                    .build());
        }
        return portfolioDtos;
    }
}
