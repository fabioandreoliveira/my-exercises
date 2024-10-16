package io.bootcamp.codeforall;


import java.sql.SQLOutput;

public class SandBox {

    public static void main(String[] args) {
        User rui = new User("Rui");
        User fabio = new User("Fabio");
        Hotel myLittleHotel = new Hotel("My Little Hotel", false);
        System.out.println("O cliente : "+ rui.getUserName()+ " neste momento "+ rui.checkcheckIn()+
                " no hotel:"+ rui.checkhotel());
        System.out.println(rui.getHotel());
        System.out.println(fabio.getHotel());
    }

}
