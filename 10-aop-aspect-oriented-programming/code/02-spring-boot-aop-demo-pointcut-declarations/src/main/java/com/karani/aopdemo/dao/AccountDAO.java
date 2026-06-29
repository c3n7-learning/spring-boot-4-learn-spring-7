package com.karani.aopdemo.dao;

import com.karani.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
