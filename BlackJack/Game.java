package BlackJack;
import java.util.*;

public class Game {    //main
    public static Scanner clav = new Scanner(System.in);

    static ArrayList<Player> players = new ArrayList<Player>();
    public static ArrayList<Card> deck = new ArrayList<Card>();
    public static ArrayList<Card> discardPile = new ArrayList<Card>();

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
            
            System.out.println("Mise de initiale : ");
            int m = clav.nextInt();

            players.add(new Player(n,m));
            // System.out.println("Joueur " + i + " : " + n + "/" + m + " $ \n");
        }
    }

    public static void distribute() {
        Player.croupier.hands.add(new ArrayList<Card>());
        for (int i=0; i<2; i++) {
            players.forEach(p -> {
                if(p.mise.get(0)>0)
                    p.giveCard(0);
            });
            Player.croupier.giveCard(0);
        }
    }

    // Met les cartes jouer dans la pile de défausse
    public static void discardHand(ArrayList<Card> hand) {
        for(Card card : hand){
            discardPile.add(card);
        }
    }

    public static void round(){
        // Valeurs de la première carte du croupier
        int valueCroupier = Player.croupier.hands.get(0).get(0).value;
        // si le croupier black jack les joueurs ne joue pas et perde leur mise
        // sauf si le joueur blackjack aussi
        // Les joueurs joue
        for(Player p : players) {
            int mis = p.mise.get(0);
            if(mis > 0) {
                System.out.println("\n-------TOUR DE : " + p.name + " -------");
                System.out.println("\nMain du croupier : [" + Player.croupier.hands.get(0).get(0).name + ", ...]");
                int value = p.calc(0);
                
                if(value == 21) {
                    System.out.println("\nVotre main : " + p.infoHand(0) + " / 21");
                    System.out.println("WOW BLACKJACK !");
                    // remove sa main et met la mise à 0
                    discardHand(p.hands.remove(0));
                    p.money += 3 * p.mise.remove(0);
                    System.out.println(p.name + " a gagné " + mis*2 + " $ / Nouveau solde : " + p.money);
                }
                else {
                    for(int i = 0; i<p.hands.size(); i++){
                        p.turn(i);
                    }
                }
                System.out.println("\n*************************************\n");
            }
        };
        // distribue des cartes au croupier
        valueCroupier = Player.croupier.calc(0);
        System.out.println("Main du croupier : " + valueCroupier + " // " + Player.croupier.infoHand(0));
        
        while(valueCroupier < 17) {
            Player.croupier.giveCard(0);
            valueCroupier = Player.croupier.calc(0);
            System.out.println("Main du croupier : " + valueCroupier + " // " + Player.croupier.infoHand(0));
        }
    }


    public static void round_end() {
        int score_croupier = Player.croupier.calc(0);
        discardHand(Player.croupier.hands.remove(0));      // défausse la main du croupier

        for (int j=0; j<players.size(); j++) {
            Player p = players.get(j);

            int nbr_hands = p.hands.size();
            int win = 0;
            for (int i=0; i<nbr_hands; i++) {
                int score_player = p.calc(0);
                discardHand(p.hands.remove(0));

                if (score_player <= 21) {
                    if (score_croupier <= 21) {
                        if (score_player > score_croupier) {
                            win += p.mise.get(0);
                            p.money += 2*p.mise.remove(0);
                        }
                        else if (score_player < score_croupier){
                            win -= p.mise.get(0);
                            p.mise.remove(0);
                        }
                        else p.money += p.mise.remove(0);
                    }
                    else {
                        win += p.mise.get(0);
                        p.money += 2*p.mise.remove(0);
                    }
                }
                else {
                    win -= p.mise.get(0);
                    p.mise.remove(0);
                }
                
            }
            if(nbr_hands > 0) {
                if (win >= 0) System.out.println(p.name + " a gagné " + win + " $ / Nouveau solde : " + p.money);
                else System.out.println(p.name + " a perdu " + -win + " $ / Nouveau solde : " + p.money);
            }

            if (p.money == 0) {
                System.out.print("--- " + p.name + " A ETE SORTI DE LA TABLE --- \n\n");
                players.remove(p);
                j--;
            }
        }
    }

    public static void game() {
        System.out.println("\n-------LA PARTIE COMMENCE / TAPER STOP AU MOMENT DE LA MISE POUR QUITTER LA TABLE--------\n");
        for(int i=0; !players.isEmpty(); i++) {
            System.out.println("\n-------ROUND N°" + (i+1) + "-------\n"); 
            for (int j=0; j<players.size(); j++){
                Player p = players.get(j);
                String play = p.mise();
                if (play.equals("STOP")) {
                    players.remove(p);
                    j--;
                }
            }
            if (!players.isEmpty()) {
                distribute();
                round();
                System.out.println("\n");
                round_end();
            }
        }
    }
    public static void main(String[] args) {
        
        init_game();
        init_deck();
        game();      // attribut play + si tout les joueurs mettent 0 dans la manche : PAS DE DISTRIBUTION
    }
} 

