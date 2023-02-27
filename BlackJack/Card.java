package BlackJack;

public class Card {
    int value;
    String color;
    String figure; 
    String name;

    public Card(int v, String c) { 
        value=v; 
        color=c; 
        name=v + " de " + c;
    }
    public Card(String f, int v, String c) {
        figure=f; 
        value=v; 
        color=c; 
        name = f + " de " + c;
    }
}
