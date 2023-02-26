package BlackJack;

public class Card {
    int value;
    String color;
    String figure; 
    String name;

    public Card(int a, String b) { 
        value=a; 
        color=b; 
        name=a + " de " + b;
    }
    public Card(String f, int a, String b) {
        figure=f; 
        value=a; 
        color=b; 
        name = f + " de " + b;
    }
}
