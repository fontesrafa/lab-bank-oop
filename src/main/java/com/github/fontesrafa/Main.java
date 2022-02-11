package com.github.fontesrafa;

import com.github.fontesrafa.Entities.Client;
import com.github.fontesrafa.Entities.IAccount;
import com.github.fontesrafa.Entities.SavingsAccount;

public class Main 
{
    public static void main( String[] args )
    {
        Client client1 = new Client("Fulano de Tal");
        Client client2 = new Client("Cicrano de Tal");
        IAccount account1 = new SavingsAccount(client1);
        IAccount account2 = new SavingsAccount(client2);        

        account1.deposit(1000.0);
        account2.deposit(1500.0);
        account1.withdraw(200.0);
        account1.transfer(150.0, account2);

        account1.printExtract();
        account2.printExtract();

    }
}
