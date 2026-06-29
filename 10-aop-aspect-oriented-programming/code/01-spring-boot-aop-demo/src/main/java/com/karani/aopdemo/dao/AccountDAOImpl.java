package com.karani.aopdemo.dao;

import com.karani.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository // Make this class available for component scanning
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");

        return false;
    }
}
