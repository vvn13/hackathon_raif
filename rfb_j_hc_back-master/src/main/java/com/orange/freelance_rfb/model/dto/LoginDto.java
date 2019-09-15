package com.orange.freelance_rfb.model.dto;

import com.orange.freelance_rfb.model.enums.AccountType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDto {
    private String login;
    private String password;
    private AccountType accountType;
    private String fullname;
}
