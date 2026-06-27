package com.karani.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository // Make this class available for component scanning
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }
}
