package TD1;
import java.util.*;

public class Exo5b {
    public static void main (String [] args) {
		Scanner clav = new Scanner(System.in);
		int i = 0;
        int nbE;

        System.out.println("Combiens d'étudiants souhaitez vous rentrer ? : ");
        nbE = clav.nextInt();

        String[] tNoms = new String[nbE];
        int[] tNotes = new int[nbE];

        while (i < nbE) {
            System.out.println("Saisir un nom : ");
            tNoms[i] = clav.next();
			System.out.println("Saisir sa note : ");
			tNotes[i] = clav.nextInt();
			
            i++;
        }

        String[] classement = new String[nbE];    //Liste des meilleurs étudiants par ordre décroissant
        String[] tNomsBis = copyS(tNoms);         // Je fais une copie des listes pour ne pas les modifier
        int[] tNotesBis = copyI(tNotes);
        int iMax = 0;
        while (tNomsBis.length > 0 ) {
            iMax = maxI(tNotesBis);               // Je récupère l'indice de la meilleure note
            add(classement,tNomsBis[iMax]);       // J'ajoute le nom correspondant à l'indice dans ma liste réponse
            tNomsBis = delS(tNomsBis,iMax);       // Je supprime le nom de la liste
            tNotesBis = delI(tNotesBis,iMax);     // Je supprime la note de la liste 
        }

        print(classement);      
    }

    public static String[] copyS(String[] t) {
        String[] rep = new String[t.length];
        for (int i=0; i<t.length; i++) rep[i] = t[i];
        return rep;
    }
    public static int[] copyI(int[] t) {
        int[] rep = new int[t.length];
        for (int i=0; i<t.length; i++) rep[i] = t[i];
        return rep;
    }

    //Fonction qui donne l'indice de l'élément max d'une liste
    public static int maxI(int[] tab) {
        int max=0;
        int indice=0;
        for (int i=0; i<tab.length; i++) {
            if (tab[i]>max) {
                max=tab[i];
                indice=i;
            }
        }
        return indice;
    }

    //Fonction qui ajoute un élément à une liste
    public static void add(String[] t, String val) {
        for (int i=0; i<t.length; i++) {
            if (t[i]==null) {
                t[i]=val;
                break;
            }
        }
    }

    //Fonctions qui suppriment l'élément d'indice i d'une liste
    public static String[] delS(String[] t, int i) {
        String[] copie = new String[t.length-1];
        int k=0;
        for (int j=0; j<t.length; j++) {
            if (j==i) j++;
            if (j==t.length) break;
            copie[k] = t[j];
            k++;
        }
        return copie;
    }
    public static int[] delI(int[] t, int i) {
        int[] copie = new int[t.length-1];
        int k=0;
        for (int j=0; j<t.length; j++) {
            if (j==i) j++;
            if (j==t.length) break;
            copie[k] = t[j];
            k++;
        }
        return copie;
    }

    //Fonction permettant d'afficher le résultat
    public static void print(String[] t) {
        String rep = t[0];
        for (int i=1; i<t.length; i++) {
            rep += " > " + t[i];
        }
        System.out.println(rep);
    }
}
