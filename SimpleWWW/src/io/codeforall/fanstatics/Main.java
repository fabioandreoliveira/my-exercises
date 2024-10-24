package io.codeforall.fanstatics;

public class Main {
    public static void main(String[] args) {
        try {
            ServerWWW serverWWW = new ServerWWW();
            serverWWW.receiveMes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
