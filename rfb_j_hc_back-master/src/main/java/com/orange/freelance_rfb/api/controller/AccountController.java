package com.orange.freelance_rfb.api.controller;

import com.orange.freelance_rfb.model.dto.FullAccountDto;
import com.orange.freelance_rfb.model.dto.LoginDto;
import com.orange.freelance_rfb.service.AccountService;
import com.orange.freelance_rfb.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    private final AccountService accountService;
    private final PortfolioService portfolioService;

    public AccountController(AccountService accountService, PortfolioService portfolioService) {
        this.accountService = accountService;
        this.portfolioService = portfolioService;
    }

    @RequestMapping("/registration")
    public void registration(@RequestBody LoginDto login, HttpServletResponse response) {
        if (accountService.registration(login.getLogin(), login.getPassword(), login.getFullname(), login.getAccountType())) {
            response.setStatus(200);
            return;
        }
        response.setStatus(300);
    }

    @RequestMapping("/money")
    public String moneyCheck(@RequestBody LoginDto login) {
        return "{\"money\":\"" + accountService.checkMoney(login.getLogin()) + "\"}";
    }

    @GetMapping("/account")
    public FullAccountDto account(@RequestParam(value = "login") String login) {
        return accountService.getAccount(login, portfolioService.findByLogin(login));
    }
}
