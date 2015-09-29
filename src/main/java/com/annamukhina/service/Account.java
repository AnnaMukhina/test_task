package com.annamukhina.service;

/**
 * @author anna_mukhina
 */
public class Account {
    private final String id;
    private final String surname;

    public Account(String id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
}
