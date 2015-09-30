package com.annamukhina.service;

import com.annamukhina.dao.Dao;
import com.annamukhina.dao.MysqlAccountDao;

import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class AccountManagerImpl implements AccountManager {
    private Dao dao;

    public AccountManagerImpl(Dao dao) {
        this.dao = dao;
    }

    public void changeSurname(Account account) {
        dao.changeSurname(account);
    }

    @Override
    public Account getParameters() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter id:");

        String id = scanner.next();

        System.out.println("Enter new surname:");

        String surname = scanner.next();

        Account account = new Account(id, surname);

        return account;
    }

    public static void main(String[] args) {
        Dao dao  = new MysqlAccountDao();

        AccountManagerImpl accountManager = new AccountManagerImpl(dao);

        Account account = accountManager.getParameters();

        accountManager.changeSurname(account);
    }
}
