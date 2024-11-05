package io.codeforall.fanstatics;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.Spliterator;

public class Main {
    public static void main(String[] args) {

        String username = "Fábio";
        String password = "fa1234";


        Prompt prompt = new Prompt(System.in, System.out);

        StringInputScanner user = new StringInputScanner();
        PasswordInputScanner pass = new PasswordInputScanner();

        user.setMessage("username:");
        pass.setMessage("password:");
        String userUsername = prompt.getUserInput(user);
        String userPassword = prompt.getUserInput(pass);

        if (userUsername.equals(username) && userPassword.equals(password)) {
            System.out.println("Welcome");
        } else {
            System.out.println("wrong");
        }

    }
}

