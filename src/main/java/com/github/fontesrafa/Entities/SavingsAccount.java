package com.github.fontesrafa.Entities;

public  class SavingsAccount extends Account{

    public SavingsAccount(Client client) {
        super(client);        
    }

    @Override
    public void printExtract() {
        System.out.println("==== SavingsAccout Extract ====");
        super.printCommonInfos();        
    }

}
