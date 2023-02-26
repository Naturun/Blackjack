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
            
        //     System.out.println("Mise de départ : ");
        //     int m = clav.nextInt();

        //     players.add(new Player(n,m));
        //     // System.out.println("Joueur " + i + " : " + n + "/" + m + " $ \n");
        // }
        players.add(new Player("Nathan", 500));
        players.add(new Player("Emilie", 1000));
    }

    public static void mise() {
        players.forEach(p -> {
            int m;
            do {
                System.out.println(p.name + " mise de 0 à " + p.money);   
                m = clav.nextInt();
            } while(m > p.money);
            if (m <= 0) p.mise.add(0);
            else {
                p.mise.add(m);
                p.money -= m;
            }
        });
    }

    public static void giveCard(ArrayList<Card> hand) {
        Card lastCard = deck.get(deck.size() - 1);
        hand.add(lastCard); 
        deck.remove(lastCard); 
    }

    public static void distribute() {
        giveCard(Player.croupier.hands.get(0));
        for (int i=0; i<2; i++) {
            players.forEach(p -> {
                giveCard(p.hands.get(0));
            });
        }
    }

    // public static void discardAll() {

    // }

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

    public static void turn() {
        players.forEach(p -> {
            if(p.mise.get(0) > 0) {

                System.out.println("Tour de " + p.name);
                for(int i = 0; i<p.hands.size(); i++){
                    ArrayList<Card> hand = p.hands.get(i);
                    int mise = p.mise.get(i);
                    int value = calc(hand);
                    System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
                        
                    if(value == 21 && p.hands.size() == 1) {
                        System.out.println("WOW BLACKJACK !");
                        p.money += 3*mise;
                        p.mise.set(0, 0);
                        break;
                    }
    
                    if(value == 21) {
                        break;
                    }
    
                    // début fonction
                    int firstCard = hand.get(0).value;
                    int secondCard = hand.get(1).value;
    
                    System.out.println("1 : Ajouter une carte à la main");
                    System.out.println("2 : Ne pas rajouter de carte");
                    System.out.println("3 : doubler la mise");
                    if (firstCard == secondCard) {System.out.println("4 : split");}
                    int rep = clav.nextInt();
    
                    if(rep == 3) {
                        p.money -= mise;
                        mise *= 2;
                        giveCard(hand);
                        value = calc(hand);
                        System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
                    }
    
                    else if(rep == 4 && firstCard == secondCard) {
                        split(p, i);
                        // fonction
                    }
    
                    while(rep == 1 && value < 21) {
                        giveCard(hand);
                        // System.out.println("hand = " + hand);
                        // System.out.println("p.hands = " + p.hands.get(i));
                        value = calc(hand);
                        System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
                        if(value < 21) {
                            System.out.println("1 : Ajouter une carte à la main");
                            System.out.println("2 : Ne pas rajouter de carte");
                            rep = clav.nextInt();
                        }
                    }
                }
                System.out.println("\n*************************************\n");
            }
        });
        // turn_end();
    }  

    public static void split(Player p, int i) {

    }
    public static void main(String[] args) {

        init_game();
        init_deck();
        mise();
        distribute();
        turn();

    }
} 
