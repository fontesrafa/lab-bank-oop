package com.github.fontesrafa.Entities;

import java.util.Objects;

public abstract class Account implements IAccount {
    
    private static final int DEFAULT_AGENCY = 1;
    private static int SEQUENCIAL = 1;

    protected int agency;
    protected int number;
    protected double balance;
    protected Client client;

    
    protected Account(Client client) {
        this.agency = Account.DEFAULT_AGENCY;
        this.number = SEQUENCIAL++;
        this.client = client;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void transfer(double amount, IAccount destinationAccount) {
        this.withdraw(amount);
        destinationAccount.deposit(amount);
    }
    public int getAgency() {
        return this.agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Account agency(int agency) {
        setAgency(agency);
        return this;
    }

    public Account number(int number) {
        setNumber(number);
        return this;
    }

    public Account balance(double balance) {
        setBalance(balance);
        return this;
    }

    public Account client(Client client) {
        setClient(client);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return agency == account.agency && number == account.number && balance == account.balance && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agency, number, balance, client);
    }

    @Override
    public String toString() {
        return "{" +
            " agency='" + getAgency() + "'" +
            ", number='" + getNumber() + "'" +
            ", balance='" + getBalance() + "'" +
            ", client='" + getClient() + "'" +
            "}";
    }

    protected void printCommonInfos() {
        System.out.println(String.format("Holder: %s", this.client.getFullName()));
        System.out.println(String.format("Agency: %d", this.agency));
        System.out.println(String.format("Number: %d", this.number));
        System.out.println(String.format("Balance: %.2f", this.balance));
    }


}
