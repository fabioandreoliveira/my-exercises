package io.codeforall.bootcamp;

public class Bank {

    int account = 0; //valor com que a minha conta inicia

   /* public Bank() {
        this.account = account;
    } */

    /*private int getAccount() {
        return account;
    }*/

    public void getDepositBank(int deposit) {
        int oldValue = account;
        if (deposit > 0) {
            account = account + deposit;
            System.out.println(Person.name + " Account: " + oldValue);
            System.out.println(Person.name + " Deposit: " + deposit);
            System.out.println(Person.name + " Account: " + account);
            return;
        }
            System.out.println("Value not accepted");

    }
    public void getwithdrawBank(int withdraw) {
        int oldValue = account;
        if (withdraw <= account && withdraw >0) {
            account = account - withdraw;
            System.out.println(Person.name + " Account: " + oldValue);
            System.out.println(Person.name + " Withdraw: " + withdraw);
            System.out.println(Person.name + " Account: " + account);
            return;
        }
            System.out.println("Value not accepted");

    }

}
