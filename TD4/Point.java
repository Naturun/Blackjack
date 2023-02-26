package TD4;

public class Point {
    private double abs,ord;
    private String nom;
    static Point orig = new Point(0, 0, "O");

    public Point (double x, double y, String n) {
        abs=x;
        ord=y;
        nom=n;
    }

    public double getAbs() { return abs; }

    public double getOrd() { return ord; }

    public String getName() { return nom; }

    public void setAbs(double a) { abs = a; }

    public void setOrd(double o) { ord = o; }

    public double getX() { return abs - orig.abs; }

    public double getY() { return ord - orig.ord; }

    public String info() { return nom + "(" + getX() + "," + getY() + ")";}

    public boolean pegX(Point b) { return abs <= b.abs; }

    public boolean pegY(Point b) { return ord <= b.ord; }

    public void translate(double x, double y) {
        abs += x;
        ord += y;
    }

    public void symetrie() {
        abs = orig.abs - getX();
        ord = orig.ord - getY();
    }
}
