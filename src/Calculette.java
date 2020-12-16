import java.util.Scanner;

public class Calculette {
	
	public void main() {
		String operation;
		String operateur = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez une opération à calculer : ");
		operation = scanner.nextLine().trim();
		
		if (operation.contains("+")) {
			operateur = "\\+";
		}
		if (operation.contains("-")) {
			operateur = "-";
		}
		if (operation.contains("*")) {
			operateur = "\\*";
		}
		if (operation.contains("/")) {
			operateur = "/";
		}
		
		String[] morceaux = operation.split(operateur);
		double morceau1 = Double.valueOf(morceaux[0]);
		double morceau2 = Double.valueOf(morceaux[1]);
		double result = 0;
		
		switch(operateur) {
			case "\\+" : 
				result = morceau1 + morceau2;
			break;
			case "-" : 
				result = morceau1 - morceau2;
			break;
			case "\\*" : 
				result = morceau1 * morceau2;
			break;
			case "/" : 
				result = morceau1 / morceau2;
			break;
		}
		
		System.out.println(result);
	}
}
