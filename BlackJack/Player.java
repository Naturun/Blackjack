package BlackJack;
import java.util.*;

// Vérifier compte en banque avant chaque action qui nécessite de l'argent
public class Player {
    String name;
    int money;
    ArrayList<Integer> mise = new ArrayList<Integer>();
    ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
    

    public Player(String n, int m) {name=n; money=m;}
    private Player() {name="Croupier";}
    public static Player croupier = new Player();

    public String infoHand(int i){
        String strCards = "[";
        ArrayList<Card> hand = hands.get(i);
        for(int j=0; j<hand.size()-1; j++) {
            strCards += hand.get(j).name + ", ";
        }
        strCards += hand.get(hand.size()-1).name + "]";
        return strCards;
    }

    public String mise() {
        String mS;
        int mI;
        do {
            System.out.println(name + " mise de 0 à " + money);   
            mS = Game.clav.next();
            if (mS.equals("STOP")) return mS;
            
            mI = Integer.parseInt(mS);
        } while(mI > money);
        if (mI <= 0) mise.add(0);
        else {
            mise.add(mI);
            money -= mI;
            hands.add(new ArrayList<Card>());   // rajoute une liste vide dans la liste des mains
        }
        return "";
    }

    public void giveCard(int i) {
        if(Game.deck.size() == 0) {
            Game.deck = (ArrayList<Card>)Game.discardPile.clone();
            Game.discardPile.clear();
            Collections.shuffle(Game.deck);
        }
        Card lastCard = Game.deck.get(Game.deck.size() - 1);
        hands.get(i).add(lastCard); 
        Game.deck.remove(lastCard);
    }

    public int calc(int i) {
        int total=0;
        int nbrAs = 0;
        ArrayList<Card> hand = hands.get(i);

        for (int j=0; j<hand.size(); j++) {
            Card card = hand.get(j);
            total += card.value;

            if (card.figure == "As") nbrAs += 1;
        }

        while (total>21 && nbrAs>0) {
            total -= 10;
            nbrAs-=1;
        }
        
        return total;
    }

    public void split(int i) {
        Card c = hands.get(i).remove(1);        //enleve la carte du dessus de la main
        hands.add(new ArrayList<Card>(Arrays.asList(c)));       //la place dans une nouvelle main

        money -= mise.get(i);
        mise.add(mise.get(i));
        giveCard(i);        //ajoute une carte à la main courante
        giveCard(hands.size()-1);       //ajoute une carte à la nouvelle main (la dernière)
    }
    
    public void turn(int i) {
        int value = calc(i);
        ArrayList<Card> hand = hands.get(i);
        int mis = mise.get(i);

        System.out.println("\nVotre main n°" + (i+1) + " : " + value + " // " + infoHand(i));

        if(value != 21) {

            int firstCard = hand.get(0).value;
            int secondCard = hand.get(1).value;

            System.out.println("1 : Ajouter une carte à la main");
            System.out.println("2 : Ne pas rajouter de carte");
            if (mis <= money) {
                System.out.println("3 : doubler la mise");
                if (firstCard == secondCard) {System.out.println("4 : split");}
            }
            int rep = Game.clav.nextInt();

            if(rep == 3) {  
                money -= mis;
                mise.set(i,mis*2);
                giveCard(i);
                value = calc(i);
                System.out.println("Votre main n°" + (i+1) + " : " + value + " || " + infoHand(i));
            }

            else if(rep == 4 && firstCard == secondCard) {
                split(i);
                turn(i);
            }

            while(rep == 1 && value < 21) {
                giveCard(i);
                value = calc(i);
                System.out.println("\nVotre main n°" + (i+1) + " : " + value + " // " + infoHand(i));
                if(value < 21) {
                    System.out.println("1 : Ajouter une carte à la main");
                    System.out.println("2 : Ne pas rajouter de carte");
                    rep = Game.clav.nextInt();
                }
            }
        }
    }
}