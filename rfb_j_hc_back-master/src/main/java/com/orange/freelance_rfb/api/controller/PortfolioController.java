package com.orange.freelance_rfb.api.controller;

import com.orange.freelance_rfb.model.dto.PortfolioDto;
import com.orange.freelance_rfb.service.PortfolioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @RequestMapping("/add")
    public void add(@RequestBody PortfolioDto portfolioDto) {
        portfolioService.add(portfolioDto.getLogin(), portfolioDto.getInfo());
    }
}
