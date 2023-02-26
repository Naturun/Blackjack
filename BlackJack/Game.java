package BlackJack;
import java.util.*;

public class Game {    //main
    static Scanner clav = new Scanner(System.in);

    static ArrayList<Player> players = new ArrayList<Player>();
    static ArrayList<Card> deck = new ArrayList<Card>();
    static ArrayList<Card> discardPile = new ArrayList<Card>();

    public static void init_deck() {
        String[] colors = {"Coeur", "Carreau", "Pique", "Trèfle"};
        int[] numbers = {2,3,4,5,6,7,8,9,10};
        String[] figures = {"Valet", "Dame", "Roi"};
        
        // for (int i=0; i<3; i++)  pour avoir 3 paquets
        for (String c : colors) {    
            for (int n : numbers) deck.add(new Card(n, c));
            for (String f : figures) deck.add(new Card(f,10,c));
            deck.add(new Card("As", 11, c));
        }
        Collections.shuffle(deck);
    }

    public static void init_game() {
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

    public static void mise() {
        players.forEach(p -> {
            int m;
            do {
                System.out.println(p.name + "mise de 0 à " + p.money);   
                m = clav.nextInt();
            } while(m > p.money);
            p.mise = m;
            p.money -= m;
        });
    }

    public static void giveCard(Player p) {
        Card lastCard = deck.get(deck.size() - 1);
        p.jeu.add(lastCard); 
        deck.remove(lastCard); 
    }

    public static void distribute() {
        giveCard(Player.croupier);
        for (int i=0; i<2; i++) {
            players.forEach(p -> {
                giveCard(p);
            });
        }
    }

    // public static void discardAll() {

    // }

    public static int calc() {}
    public static boolean check() {}

    public static void tour() {}
    public static void main(String[] args) {

        init_game();
        init_deck();
        mise();
        distribute();
        System.out.println(Player.croupier.jeu);
        players.forEach(p -> System.out.println(p.jeu));
    }
} 
