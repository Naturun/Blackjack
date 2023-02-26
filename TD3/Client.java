package TD3;

public class Client {
    // Déclaration des atributs
    int CIN;
    String nom;
    String prenom;
    String tel="";

    // Constructeur

    public Client(int cin, String n, String p, String t) {
        CIN=cin;
        nom=n;
        prenom=p;
        tel=t;       
    }

    public Client(int cin, String n, String p) {
        CIN=cin;
        nom=n;
        prenom=p;       
    }

    public void afficher () {
        System.out.println(" CIN : "+CIN);
        System.out.println(" Nom : "+nom);
        System.out.println(" Prenom : "+prenom);
        if (!tel.equals("")) System.out.println(" Tel : "+tel);
        System.out.println("---------------------------");
    }

}

