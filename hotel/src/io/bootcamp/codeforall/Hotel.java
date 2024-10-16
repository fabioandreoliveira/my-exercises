package io.bootcamp.codeforall;

public class Hotel {
    private String nameHotel;
    public boolean checkIn;

    public Room room1 = new Room();
    public Room room2 = new Room();
    public Room room3 = new Room();

    public Hotel(String nameHotel, boolean checkIn) {
        this.nameHotel = nameHotel;
        this.checkIn = checkIn;

    }

    public String getnameHotel() {
        return nameHotel;
    }

    public String getcheckIn() {
        if (checkIn == true) {
            return "Check in feito";
        } else {
            return "User não está no Hotel";
        }
    }

    public String getChoseRoom() {
        return room1.choseRoom();
    }
}
