package BlackJack;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> b = a;
        b.add(5);
        System.out.println(a);
        System.out.println(b);

    }
}
  