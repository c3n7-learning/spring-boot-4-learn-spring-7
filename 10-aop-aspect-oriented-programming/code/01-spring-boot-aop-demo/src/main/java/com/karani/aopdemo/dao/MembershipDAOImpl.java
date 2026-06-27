package com.karani.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository // Make this class available for component scanning
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }
}
