package BlackJack;

import java.util.ArrayList;

public class Main {

    static ArrayList<Card> a = new ArrayList<Card>();

    public static void test() {
        System.out.println(a);
    }
    public static void main(String[] args) {

        a.add(new Card(5, "coeur"));
        System.out.println(a);
        test();
    }
}
