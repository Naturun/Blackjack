package BlackJack;
import java.util.*;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    Deck discardPile = new Deck();

    public void init_game() {
        Scanner clav = new Scanner(System.in);

        System.out.println("Nombre de joueurs : ");
        int nbrPlayer = clav.nextInt();

        for (int i=1; i<=nbrPlayer; i++) {
            System.out.println("Nom du joueur " + i + " : ");
            String n = clav.next();
            
            System.out.println("Mise de départ : ");
            int m = clav.nextInt();

            players.add(new Player(n,m));
            // System.out.println("Joueur " + i + " : " + n + "/" + m + " $ \n");
        }
    }

    public void mise() {

    }

    public void distribute() {

    }

    public void discardAll() {

    }
} 
