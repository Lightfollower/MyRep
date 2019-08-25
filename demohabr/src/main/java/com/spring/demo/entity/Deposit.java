package com.spring.demo.entity;

import javax.persistence.Entity;
import java.sql.Time;

//@Entity
public class Deposit {
    public Client client;
    public Bank bank;
    public Time openDate;
    public int interest;
    public int term;
}
