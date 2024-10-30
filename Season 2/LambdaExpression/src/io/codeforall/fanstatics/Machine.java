package io.codeforall.fanstatics;

public class Machine {
    public static void main(String[] args) {
        int result;
        String string;

        MonoOperation increment = n1 -> n1 + 1;
        result = increment.execute(1);
        System.out.println(result);

        BiOperation sum = (n1, n2) -> n1 + n2;
        result = sum.execute(1, 1);
        System.out.println(result);

    }

}
