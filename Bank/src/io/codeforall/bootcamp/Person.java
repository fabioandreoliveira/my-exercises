package io.codeforall.bootcamp;

public class Person {

    static String name; //

    public Person(String name) { //método construtor
        this.name = name;
    }

    /*public String getName() {
        return name;
    }*/

    Bank bank = new Bank();

    public void getdeposit(int deposit) {
        bank.getDepositBank(deposit);
    }

    public void getwithdraw(int withdraw) {
        bank.getwithdrawBank(withdraw);
    }


}