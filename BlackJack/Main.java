package BlackJack;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(5);
        test.add(4);
        test.add(10);
        for (int i=0; i<test.size(); i++) {

            if (test.get(i)==5) {
                test.remove(test.get(i));
                i--;
            }
        }
        System.out.println(test);
    }
}
  