package BlackJack;
import java.util.*;

public class Player {
    String name;
    int money;
    ArrayList<Integer> mise = new ArrayList<Integer>();
    ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
    

    public Player(String n, int m) {name=n; money=m; hands.add(new ArrayList<Card>());}
    private Player() {name="Croupier"; hands.add(new ArrayList<Card>());}
    public static Player croupier = new Player();

    
}
 