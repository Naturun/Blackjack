package TD2;

public class Methodes {
    public static void main(String[] args) {
        int[] test = {2,3,4,10,15,7};
        System.out.println(search(11,test));
    }

    public static int somme (int[] tab) {
        int res=0;
        for (int i : tab) {
            res+=i;
        }
        return res;
    }

    public static int search (int n, int[] tab) {
        for (int i=0; i<tab.length; i++) {
            if (tab[i]==n) return i;
        }
        return -1;
    }
}

