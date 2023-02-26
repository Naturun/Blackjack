package TD4;

public class Dessin {
    Rectangle[] tab = new Rectangle[0];

    public void add(Rectangle r) {
        Rectangle newTab[] = new Rectangle[tab.length + 1];
        for (int i=0; i<tab.length; i++) newTab[i] = tab[i];
        newTab[newTab.length - 1] = r;
        tab = newTab;
    }

    public void translate(double x, double y) { for (Rectangle r : tab) r.translate(x, y); }

    public void symetrie() { for (Rectangle r : tab) r.symetrie(); }

    public void affiche() {
        for (Rectangle r : tab) System.out.println(r.info());
    }

    public double surface() {
        double maxAbs = -1.0/0.0;
        double maxOrd = -1.0/0.0;
        double minAbs = 1.0/0.0;
        double minOrd = 1.0/0.0;

        for (Rectangle r : tab) {
            if (r.getPGAbs() > maxAbs) maxAbs = r.getPGAbs();
            if (r.getPGOrd() > maxOrd) maxOrd = r.getPGOrd();

            if (r.getPPAbs() < minAbs) minAbs = r.getPPAbs();
            if (r.getPPOrd() < minAbs) minOrd = r.getPPOrd();
        }

        Rectangle R = new Rectangle(new Point(maxAbs,maxOrd,"max"), new Point(minAbs,minOrd,"min"));
        return R.surface();
    }
}
 