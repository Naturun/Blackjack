package TD4;

public class Test {
    public static void main (String [] args) { 
        Point a = new Point(2, 5, "a");
        Point b = new Point(7, -5, "b");

        Point c = new Point(10, 2, "a");
        Point d = new Point(-10, 3, "b");

        Rectangle r = new Rectangle(a,b);
        Rectangle r2 = new Rectangle(c,d);

        Dessin t = new Dessin();
        t.add(r);
        t.add(r2);
        
        Rectangle f = new Rectangle(new Point(1,2,"h"), new Point(2,2,"g"));
        // t.add(f);
        System.out.println(t.surface());

    }
}
