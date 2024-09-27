package io.codeforall.bootcamp;

public enum HandType{
        PAPER("Paper"),
        ROCK("Rock"),
        SCISSORS("Scissors");

        private String handType;

    HandType(String handType){
        this.handType = handType;
    }
    public String GetHandType(){
        return this.handType;

    }

    public static HandType randomhandType() {

      int randomtype = (int) Math.random()*4;

        HandType[] handTypes = HandType.values();

        return handTypes[randomtype];
    }

}




