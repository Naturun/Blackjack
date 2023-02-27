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
        int m;
        do {
            System.out.println(name + " mise de 0 à " + money);   
            m = clav.nextInt();
        } while(m > money);
        if (m <= 0) mise.add(0);
        else {
            mise.add(m);
            money -= m;
        }
    }

    public void split(int i) {
        Card c = hands.get(i).remove(1);      //enleve la carte du dessus de la main
        hands.add(new ArrayList<Card>(Arrays.asList(c)));   //la place dans une nouvelle main

        mise.add(mise.get(i));
        giveCard(hands.get(i));
        giveCard(hands.get(i+1));
    }
    
//     public void turn() {
//         if(mise.get(0) > 0) {
//             System.out.println("Tour de " + name);
//             for(int i = 0; i<hands.size(); i++){
//                 ArrayList<Card> hand = hands.get(i);
//                 int mis = mise.get(i);
//                 int value = calc(hand);
//                 System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
                    
//                 if(value == 21 && hands.size() == 1) {
//                     System.out.println("WOW BLACKJACK !");
//                     money += 3*mis;
//                     mise.set(0, 0);
//                     break;
//                 }

//                 if(value == 21) {
//                     break;
//                 }

//                 // début fonction
//                 int firstCard = hand.get(0).value;
//                 int secondCard = hand.get(1).value;

//                 System.out.println("1 : Ajouter une carte à la main");
//                 System.out.println("2 : Ne pas rajouter de carte");
//                 System.out.println("3 : doubler la mise");
//                 if (firstCard == secondCard) {System.out.println("4 : split");}
//                 int rep = clav.nextInt();

//                 if(rep == 3) {
//                     money -= mis;
//                     mis *= 2;
//                     giveCard(hand);
//                     value = calc(hand);
//                     System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
//                 }

//                 else if(rep == 4 && firstCard == secondCard) {
//                     split(i);
//                     // fonction
//                 }

//                 while(rep == 1 && value < 21) {
//                     giveCard(hand);
//                     // System.out.println("hand = " + hand);
//                     // System.out.println("hands = " + hands.get(i));
//                     value = calc(hand);
//                     System.out.println("Valeur de votre main n°" + (i+1) + " : " + value);
//                     if(value < 21) {
//                         System.out.println("1 : Ajouter une carte à la main");
//                         System.out.println("2 : Ne pas rajouter de carte");
//                         rep = clav.nextInt();
//                     }
//                 }
//             }
//             System.out.println("\n*************************************\n");
//     }
// }
}
 