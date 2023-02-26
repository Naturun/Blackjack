package TD3;
public class Test {
    public static void main (String [] args) {
        Client c = new Client(123,"toto","titi","0689245851");
        Compte cmp = new Compte(c,34);

        cmp.afficher();
        cmp.credit(25);
        cmp.afficher();

    }
}
