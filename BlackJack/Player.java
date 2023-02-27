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

    public void mise() {     //forEach mise();   dans Game
        // int m;
        // do {
        //     System.out.println(name + " mise de 0 à " + money);   
        //     m = Game.clav.nextInt();
        // } while(m > money);
        // if (m <= 0) mise.add(0);
        // else {
            mise.add(100);
            money -= 100;
        // }
    }

    public void giveCard(int i) {
        Card lastCard = Game.deck.get(Game.deck.size() - 1);
        hands.get(i).add(lastCard); 
        Game.deck.remove(lastCard);
    }

    public int calc(int i) {
        int total=0;
        int nbrAs = 0;
        ArrayList<Card> hand = hands.get(i);

        for (int j=0; i<hand.size(); i++) {
            Card card = hand.get(i);
            total += card.value;

            if (card.figure == "As") nbrAs += 1;
        }

        while (total>21 && nbrAs>0) total -= 10;
        
        return total;
    }

    public void split(int i) {
        Card c = hands.get(i).remove(1);      //enleve la carte du dessus de la main
        hands.add(new ArrayList<Card>(Arrays.asList(c)));   //la place dans une nouvelle main

        mise.add(mise.get(i));
        giveCard(i);
        giveCard(i+1);
        System.out.println(hands.get(i));
        System.out.println(hands.get(i+1));
    }
    
    public void turn(int i) {
        int value = calc(i);

        ArrayList<Card> hand = hands.get(i);
        int mis = mise.get(i);

        System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
        System.out.println(hands.get(i).get(0).name);
        System.out.println(hands.get(i).get(1).name);


        if(value != 21) {

            // début fonction
            int firstCard = hand.get(0).value;
            int secondCard = hand.get(1).value;

            System.out.println("1 : Ajouter une carte à la main");
            System.out.println("2 : Ne pas rajouter de carte");
            System.out.println("3 : doubler la mise");
            if (firstCard == secondCard) {System.out.println("4 : split");}
            int rep = Game.clav.nextInt();

            if(rep == 3) {  //condition sur money pour double et split
                money -= mis;
                mise.set(i,mis*2);
                giveCard(i);
                value = calc(i);
                System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
                System.out.println("money / mise " + money + " : " + mise);
            }

            else if(rep == 4 && firstCard == secondCard) {
                split(i);
                turn(i);
            }

            while(rep == 1 && value < 21) {
                giveCard(i);
                // System.out.println("hand = " + hand);
                // System.out.println("hands = " + hands.get(i));
                value = calc(i);
                System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
                if(value < 21) {
                    System.out.println("1 : Ajouter une carte à la main");
                    System.out.println("2 : Ne pas rajouter de carte");
                    rep = Game.clav.nextInt();
                }
            }
        }
    }
}