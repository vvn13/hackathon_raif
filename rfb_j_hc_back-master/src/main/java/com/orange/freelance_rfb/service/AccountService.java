package com.orange.freelance_rfb.service;

import com.orange.freelance_rfb.model.dto.FullAccountDto;
import com.orange.freelance_rfb.model.dto.PortfolioDto;
import com.orange.freelance_rfb.model.entity.Account;
import com.orange.freelance_rfb.model.enums.AccountType;
import com.orange.freelance_rfb.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean registration(String login, String password, String name, AccountType type) {
        if (accountRepository.findByLogin(login) == null) {
            Account account = Account.builder()
                    .login(login)
                    .password(password)
                    .fullname(name)
                    .account_type(type.name())
                    .balance(1000000)
                    .build();
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }

    public int checkMoney(String login) {
        return accountRepository.findByLogin(login).getBalance();
    }

    public FullAccountDto getAccount(String login, List<PortfolioDto> portfolioDtos) {
        Account account = accountRepository.findByLogin(login);
        FullAccountDto fullAccountDto = FullAccountDto
                .builder()
                .login(login)
                .name(account.getFullname())
                .ratingNumber(account.getNumberOfRatings())
                .ratingSum(account.getSumOfRatings())
                .portfolioList(portfolioDtos)
                .build();
        return fullAccountDto;
    }
}
