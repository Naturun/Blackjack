package BlackJack;
import java.util.*;

public class Game {    //main
    public static Scanner clav = new Scanner(System.in);

    static ArrayList<Player> players = new ArrayList<Player>();
    public static ArrayList<Card> deck = new ArrayList<Card>();
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

    public static void distribute() {
        for (int i=0; i<2; i++) {
            players.forEach(p -> {
                p.giveCard(0);
            });
            Player.croupier.giveCard(0);
        }
    }

    public static void round(){
        players.forEach(p -> {
            if(p.mise.get(0) > 0) {
                System.out.println("Tour de " + p.name);
                int value = p.calc(0);
                System.out.println("Valeur de votre main n°1 : " + value);
                    
                if(value == 21) {
                    System.out.println("WOW BLACKJACK !");
                    p.money += 3*p.mise.get(0);
                    p.mise.set(0, 0);
                }
                else {
                    for(int i = 0; i<p.hands.size(); i++){
                        p.turn(i);
                    }
                }
                System.out.println("\n*************************************\n");
            }
        });
    }


    public static void round_end() {   //AFFICHER SI WIN OU LOOSE
        int score_croupier = Player.croupier.calc(0);
        System.out.println("croupier " + score_croupier);
        players.forEach(p -> {
            int nbr_hands = p.hands.size();
            for (int i=0; i<nbr_hands; i++) {
                int score_player = p.calc(0);
                p.hands.remove(0);
                if (score_player > score_croupier) p.money += 2*p.mise.remove(0);
                else if (score_player == score_croupier) p.money += p.mise.remove(0);
                else p.mise.remove(0);
            }
        });
    }
    public static void main(String[] args) {

        init_game();
        init_deck();
        players.forEach(p -> {
            p.mise();
        });
        distribute();
        round();
        round_end();


    }
} 
