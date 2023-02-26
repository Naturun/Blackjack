package BlackJack;
import java.util.*;

public class Player {
    String name;
    int money;
    int mise=0;
    // boolean play = true;    false si mise = 0;
    ArrayList<Card> jeu = new ArrayList<Card>();

    public Player(String n, int m) {name=n; money=m;}
    private Player() {name="Croupier";}
    public static Player croupier = new Player();

    
}
 