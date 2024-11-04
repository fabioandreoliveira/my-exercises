package io.codeforall.fanstatics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

       String newMessage = Arrays.stream(message.split(" "))
                .filter(word -> !word.equals("garbage"))
                .map(String::toUpperCase)
                .reduce(" ", (a,b) -> a + " " + b);
        System.out.println(newMessage);


    }
}
