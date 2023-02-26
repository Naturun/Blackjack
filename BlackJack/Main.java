package BlackJack;

public class Main {
    public static void main(String[] args) {
        Deck test = new Deck();
        test.init_deck();
        test.shuffle();
        
        Game a = new Game();
        a.init_game();
        

    }
}
