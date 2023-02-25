package BlackJack;

public class Main {
    public static void main(String[] args) {
        Deck test = new Deck();
        test.init_deck();
        test.shuffle();
        test.print();
        test.pop();
        System.out.println(test.size());
        test.print();

    }
}
