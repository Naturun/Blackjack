package TD3;
import java.util.*;

public class Main {
    public static Client creerClient() {
        Scanner clav = new Scanner(System.in);
        int cin=clav.nextInt();
        String nom=clav.nextLine();
        String prenom=clav.nextLine();
        System.out.println("Voulez-vous saisir un tel ? o/n ");
        String rep=clav.nextLine();  
        if (rep.equals("o")) {
            String tel=clav.nextLine();
            return new Client(cin,nom,prenom,tel);
        }   
        return new Client(cin,nom,prenom);
    }

    public static Compte creerCompte(Client c, double s) {
        return new Compte(c,s);
    }

    public static Client findCin(Client[] t, int cin) {
        for (Client c : t) {
            if (c.CIN==cin) return c;
        }
        return null;
    }

    public static void debitClient(Compte[] t, int cin, double s) {
        for (Compte c : t) {
            if (c.prop.CIN==cin) c.debit(s);;
        }
    }

    public static void creditClient(Compte[] t, int cin, double s) {
        for (Compte c : t) {
            if (c.prop.CIN==cin) c.credit(s);;
        }
    }

    public static void main (String [] args) {
        Scanner clav = new Scanner(System.in);
        System.out.println("Combien de clients voulez-vous ajouter ? ")

        Client[] listClient = new Client[clav.nextInt()];
        Compte[] listCompte = new Compte[clav.nextInt()];

        for (int i=0; i<listClient.length; i++) {
            System.out.println("Saisie du client " + (i+1));
            listClient[i]=creerClient();
            System.out.println("Donner un solde initial : ");
            listCompte[i]=creerCompte(listClient[i],clav.nextDouble());
        }

        System.out.println("Saisir le CIN du client : ");
        int cin=clav.nextInt();
        Client c = findCin(listClient, cin);
        System.out.println("Saisir le montant à débiter : ");
        double somme=clav.nextDouble();
        debitClient(listCompte, cin, somme);
    }
    
}
