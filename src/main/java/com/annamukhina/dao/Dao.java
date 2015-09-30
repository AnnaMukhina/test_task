package com.annamukhina.dao;

import com.annamukhina.service.Account;

/**
 * @author anna_mukhina
 */
public interface Dao {
    void checkAccount(Account account);
    void changeSurname(Account account);
}
