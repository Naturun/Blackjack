package BlackJack;

public class Card {
    int number;
    String color;
    String figure; 
    String name;

    public Card(int a, String b) { 
        number=a; 
        color=b; 
        name=a + " de " + b;
    }
    public Card(String f, int a, String b) {
        figure=f; 
        number=a; 
        color=b; 
        name = f + " de " + b;
    }
}
