package TD3;
public class Compte {
    double solde=0;
    Client prop;

    public Compte(Client c, double s) {
        prop=c;
        solde=s;
    }

    public Compte(Client c) {
        prop=c;
    }

    public void credit(double somme) {
        solde+=somme;
    }
    public void debit(double somme) {
        solde-=somme;
    }

    public void afficher () {
        System.out.println("Propriétaire : ");
        prop.afficher();
        System.out.println("Solde : " + solde);
        System.out.println("++++++++++++++++++++++++++++++");
    }
}
