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
        // System.out.println("Nombre de joueurs : ");
        // int nbrPlayer = clav.nextInt();

        // for (int i=1; i<=nbrPlayer; i++) {
        //     System.out.println("Nom du joueur " + i + " : ");
        //     String n = clav.next();
            
        //     System.out.println("Mise de initiale : ");
        //     int m = clav.nextInt();

        //     players.add(new Player(n,m));
        //     // System.out.println("Joueur " + i + " : " + n + "/" + m + " $ \n");
        // }
        players.add(new Player("Nathan", 500));
        players.add(new Player("Emilie", 1000));
    }

    public static void giveCard(ArrayList<Card> hand) {
        Card lastCard = deck.get(deck.size() - 1);
        hand.add(lastCard); 
        deck.remove(lastCard); 
    }

    public static void distribute() {
        for (int i=0; i<2; i++) {
            players.forEach(p -> {
                giveCard(p.hands.get(0));
            });
            giveCard(Player.croupier.hands.get(0));
        }
    }

    public static int calc(ArrayList<Card> hand) {
        int total=0;
        int nbrAs = 0;

        for (int i=0; i<hand.size(); i++) {
            Card card = hand.get(i);
            total += card.value;

            if (card.figure == "As") nbrAs += 1;
        }

        while (total>21 && nbrAs>0) total -= 10;
        
        return total;
    }


    public static void round_end() {   //AFFICHER SI WIN OU LOOSE
        int score_croupier = calc(Player.croupier.hands.get(0));
        System.out.println("croupier " + score_croupier);
        players.forEach(p -> {
            int nbr_hands = p.hands.size();
            for (int i=0; i<nbr_hands; i++) {
                int score_player = calc(p.hands.remove(0));
                if (score_player > score_croupier) p.money += 2*p.mise.remove(0);
                else if (score_player == score_croupier) p.money += p.mise.remove(0);
                else p.mise.remove(0);
            }
        });
    }
    public static void main(String[] args) {

        init_game();
        init_deck();
        // mise();
        distribute();
        round_end();


    }
} 
