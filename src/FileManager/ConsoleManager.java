package FileManager;

import java.util.Scanner;

public class ConsoleManager {
	
	public static void printToConsole(String text, boolean breakline) {
		if(breakline) {
			System.out.println(text);
		} else {
			System.out.print(text);
		}
	}
	
	public static void consoleBreakLine() {
		System.out.println("");
	}
	
	public static void consoleLine() {
		System.out.println("------------------------------------------------");
	}
	
	public static String readUserInput() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}