package BlackJack;
import java.util.*;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();

    public void init_deck() {
        String[] colors = {"Coeur", "Carreau", "Pique", "Trèfle"};
        int[] numbers = {2,3,4,5,6,7,8,9,10};
        String[] figures = {"Valet", "Dame", "Roi"};
        
        for (String c : colors) {
            for (int n : numbers) deck.add(new Card(n, c));
            for (String f : figures) deck.add(new Card(f,10,c));
            deck.add(new Card("As", 11, c));
        }
    }

    public void print() { deck.forEach((c) -> System.out.println(c.name)); }

    public int size() { return deck.size(); }

    public void shuffle() { Collections.shuffle(deck); }

    public void add(Card a) { deck.add(a); }

    public void pop() { deck.remove(deck.size()-1); }
}
