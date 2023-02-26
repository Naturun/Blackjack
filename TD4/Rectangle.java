package TD4;

public class Rectangle {
    Point p1;
    Point p2;
    String nom;

    public Rectangle(Point a, Point b) {
        p1 = a;
        p2 = b;
        nom = a.getName() + b.getName();
    }

    public double getPPAbs() {
        if (p1.pegX(p2)) return p1.getAbs();      // Math.min(p1.getAbs(),p2.getAbs())
        else return p2.getAbs();
    }

    public double getPGAbs() {
        if (p1.pegX(p2)) return p2.getAbs();      // Math.max(p1.getAbs(),p2.getAbs())
        else return p1.getAbs();
    }

    public double getPPOrd() {
        if (p1.pegY(p2)) return p1.getOrd();
        else return p2.getOrd();
    }

    public double getPGOrd() {
        if (p1.pegY(p2)) return p2.getOrd();
        else return p1.getOrd();
    }

    public void translate(double x, double y) {
        p1.translate(x, y);
        p2.translate(x, y);
    }

    public void symetrie() {
        p1.symetrie();
        p2.symetrie();
    }

    public double surface() {
        double L = getPGAbs() - getPPAbs();
        double l = getPGOrd() - getPPOrd();
        return l*L; 
    }

    public String info() {
        return nom + "[" + p1.info() + "," + p2.info() + "]";
    }
}
