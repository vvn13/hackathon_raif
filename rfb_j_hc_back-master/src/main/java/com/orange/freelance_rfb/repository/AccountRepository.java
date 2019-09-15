package com.orange.freelance_rfb.repository;

import com.orange.freelance_rfb.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
    Account findByLogin(String login);
}
