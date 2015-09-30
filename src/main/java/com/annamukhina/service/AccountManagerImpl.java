package com.annamukhina.service;

import com.annamukhina.dao.Dao;

/**
 * @author anna_mukhina
 */
public class AccountManagerImpl implements AccountManager {
    private Dao dao;

    public AccountManagerImpl(Dao dao) {
        this.dao = dao;
    }

    public Account getAccountById(String id) {

    }

    public void changeSurname(Account account) {

    }

    public void updateAccount() {

    }
}
