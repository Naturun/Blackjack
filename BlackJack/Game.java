package BlackJack;
import java.util.*;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    Deck discardPile = new Deck();

    public void init_game() {
        Player croupier = new Player();
        players.add(croupier);

        Scanner clav = new Scanner(System.in);
        for (int i=1; i<=clav.nextInt(); i++) {
            System.out.println("");
        }
    }

    public void mise() {

    }

    public void distribute() {

    }

    public void discardAll() {

    }
} 
