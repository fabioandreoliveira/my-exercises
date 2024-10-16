package io.bootcamp.codeforall;

public class User {
    private String userName;
    private Hotel hotel;


    public User(String userName, Hotel hotel) {
        this.userName = userName;
        this.hotel =  new Hotel("Hilton",false);
    }

    public String getUserName() {
        return userName;
    }
    public String checkhotel(){
       return hotel.getnameHotel();
    }
    public String checkcheckIn(){
        return hotel.getcheckIn();
    }

    public Hotel getHotel() {
        return hotel;
    }
}

