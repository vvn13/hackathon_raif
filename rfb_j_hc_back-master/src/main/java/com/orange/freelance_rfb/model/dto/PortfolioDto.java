package com.orange.freelance_rfb.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PortfolioDto {
    private String login;
    private String info;
}
