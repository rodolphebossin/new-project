package FileManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileManager {
	private String currentPath;

	public void main() throws IOException {
		manager();
	}

	private void manager() throws IOException {
		
		boolean rejouer = true;
		currentPath = "/Users/rodolphebossin/Documents/Humanbooster/Cours";
		
		do {
			DisplayMenu();

			switch(ConsoleManager.readUserInput()) {
			case "1" : 
				printListFile();
				break;
			case "2" : 
				createFolder();
				break;
			case "3" : 
				deleteFolder();
				break;
			case "4" : 
				createFile();
				break;
			case "5" : 
				deleteFile();
				break; 
			case "6" : 
				getInFolder();
				break; 
			case "7" : 
				exitFolder();
				break; 
			case "8" : 
				rejouer = false;
				break; 	
			}
		} while (rejouer);
	}
	
	


	private String[] listFile() {
		
		File folder = new File(this.currentPath);
		String[] fileNames = folder.list();
		return fileNames;
	}
	
	private void printListFile() {
		String[] fileNames = listFile();
		ConsoleManager.consoleBreakLine();
		ConsoleManager.consoleLine();
		
		if (fileNames != null &&fileNames.length > 0) {
			int compteur = 1;
			for (String i : fileNames) {
				ConsoleManager.printToConsole((compteur + " - " + i), true);
				compteur++;
			}

		} else {
			ConsoleManager.printToConsole("Ce dossier est vide", true);
		}
		
		ConsoleManager.consoleLine();
	}

	private void createFolder() {

		String[] fileNames = listFile();
		String dossier;

		ConsoleManager.printToConsole("Entrez le nom du dossier", true);

		boolean alreadyExists = false;
		
		do {dossier = ConsoleManager.readUserInput();
			
			for (String i : fileNames) {
				if (i.equals(dossier) ) {
	                alreadyExists = true;
	                ConsoleManager.printToConsole("Ce dossier existe déjà, entrez un autre nom.", true);
	                break;
	            }
				alreadyExists = false;
			}
		} while (alreadyExists);
		
		File folder = new File(currentPath + "/" + dossier);
		
		folder.mkdir();
		
		ConsoleManager.consoleBreakLine();
		ConsoleManager.consoleLine();ConsoleManager.consoleBreakLine();
		
		ConsoleManager.printToConsole("Dossier créé", true);
		
		ConsoleManager.consoleBreakLine();
		ConsoleManager.consoleLine();
	}

	private void deleteFolder() {
		String[] fileNames = listFile();
		printListFile();
		ConsoleManager.printToConsole("Sélectionnez un dossier.",true);
		ConsoleManager.consoleBreakLine();
		File folder = new File(currentPath + "/" + fileNames[(Integer.parseInt(ConsoleManager.readUserInput())-1)]);
		folder.delete();
		printListFile();
	}

	private void createFile() throws IOException {
		String tempPath;
		
		ConsoleManager.printToConsole("Entrez le nom du fichier", true);
		tempPath = currentPath + "/" + ConsoleManager.readUserInput();
		
		ConsoleManager.printToConsole("Entrez le nom de l'extension du fichier", true);
		tempPath = tempPath + ConsoleManager.readUserInput();
		
		File file = new File(tempPath);
		file.createNewFile();
		printListFile();
	}

	private void deleteFile() {
		String[] fileNames = listFile();
		printListFile();
		ConsoleManager.printToConsole("Sélectionnez un fichier.",true);
		ConsoleManager.consoleBreakLine();
		File file = new File(currentPath + "/" + fileNames[(Integer.parseInt(ConsoleManager.readUserInput())-1)]);
		file.delete();
		printListFile();
	}

	private void getInFolder() {
		String[] fileNames = listFile();
		printListFile();
		ConsoleManager.printToConsole("Sélectionnez le dossier dans lequel vous voulez entrer.",true);
		ConsoleManager.consoleBreakLine();
		this.currentPath = currentPath + "/" + fileNames[(Integer.parseInt(ConsoleManager.readUserInput())-1)];
		File folder = new File(this.currentPath);
		printListFile();
	}

	private void exitFolder() {
		File folder = new File(currentPath);
		this.currentPath = currentPath.replace(("/"+folder.getName()), "");
		printListFile();
	}
	
	private void DisplayMenu() {
		ConsoleManager.consoleBreakLine();
		ConsoleManager.printToConsole("Quelle opération souhaitez vous effectuer ? ", true);
		ConsoleManager.printToConsole("------------------------------------------------",true);
		ConsoleManager.printToConsole("1 - Lister les fichiers et dossiers",true);
		ConsoleManager.printToConsole("2 - Créer un dossier",true);
		ConsoleManager.printToConsole("3 - Supprimer un dossier",true);
		ConsoleManager.printToConsole("4 - Créer un fichier",true);
		ConsoleManager.printToConsole("5 - Supprimer un fichier",true);
		ConsoleManager.printToConsole("6 - Entrer dans un dossier",true);
		ConsoleManager.printToConsole("7 - Sortir du dossier",true);
		ConsoleManager.printToConsole("8 - Sortir",true);
		ConsoleManager.printToConsole("------------------------------------------------",true);
	}

}
