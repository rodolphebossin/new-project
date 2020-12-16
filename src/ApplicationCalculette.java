import java.util.Scanner;

public class ApplicationCalculette {

	public static void main(String[] args) {
		
		boolean rejouer = true;
		do {
			Calculette calculette = new Calculette();
			calculette.main();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Voulez vous rejouer ? OUI/NON");
			String decision = scanner.nextLine().toUpperCase();
			if (decision.equals("NON")) {
				rejouer = false;
			} continue;
		} while(rejouer);
	}

}
