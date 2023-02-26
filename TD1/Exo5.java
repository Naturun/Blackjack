package TD1;
import java.util.*;

public class Exo5{
	public static void main (String [] args) {
		Scanner clav = new Scanner(System.in);
		int continu = 1;
		ArrayList<String> tNoms = new ArrayList<String>();
		ArrayList<Float> tNotes = new ArrayList<Float>();
		
		do {
			System.out.println("Saisir un nom : ");
			tNoms.add(clav.next());
			System.out.println("Saisir sa note : ");
			tNotes.add(clav.nextFloat());
			
			System.out.println("Saisir 1 pour rajoutez d'autres personnes, 0 sinon");
			continu = clav.nextInt();
		}while (continu == 1);

		String order = "";
		ArrayList<String> tNomsBis = new ArrayList<String>(tNoms);
		ArrayList<Float> tNotesBis = new ArrayList<Float>(tNotes);

		while (tNotesBis.size() > 1) {
			float max = Collections.max(tNotesBis);
			int i = tNotesBis.indexOf(max);
			order += tNomsBis.get(i) + " > ";
			tNotesBis.remove(i);
			tNomsBis.remove(i);
		}

		order += tNomsBis.get(0);

		System.out.println("Meilleurs étudiants par ordre décroissant : " + order);

	}
}

