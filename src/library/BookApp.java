package library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {
	
	private BookMethods bookMethods;
	private Scanner scan;
	
	public BookApp() {
		bookMethods = new BookMethods();
		scan = new Scanner(System.in);
    }
	
	public void run() {

        String answer;

        do {
            // print the menu & get the user's answer back in return
            answer = printMenu();

            // handle the user action
            handleAction(answer);
        } while (!answer.equalsIgnoreCase(UserActionsBook.EXIT.getValue())); // loop while until user wants to exit
        
    }
	
	private void handleAction(String action) {
        if (action.equalsIgnoreCase(UserActionsBook.ADD_BOOK.getValue())) {
        	addBookToList();
        }
        
        if (action.equalsIgnoreCase(UserActionsBook.DELETE_BOOK.getValue())) {
        	deleteBookFromList();
        }
        
        if (action.equalsIgnoreCase(UserActionsBook.LIST_BOOKS.getValue())) {
        	printBookList();
        }
        
        if (action.equalsIgnoreCase(UserActionsBook.BORROW_BOOK.getValue())) {
        	borrowBook();
        }
        
        if (action.equalsIgnoreCase(UserActionsBook.RETURN_BOOK.getValue())) {
        	returnBook();
        }
        
        if (action.equalsIgnoreCase(UserActionsBook.CHECK_BORROWED_BOOKS.getValue())) {
        	checkBorrowedBooks();
        }

    }
	
	private String printMenu() {
        boolean rightAnswer = false;
        String answer = "";

        do {
            // print the option menu
        	System.out.println("What do you want to do ? ");
        	System.out.println(UserActionsBook.ADD_BOOK.getValue() + " - Add a book to the list ");
        	System.out.println(UserActionsBook.DELETE_BOOK.getValue() + " - Remove a book from the list ");
        	System.out.println(UserActionsBook.LIST_BOOKS.getValue() + " - List the books from the list ");
        	System.out.println(UserActionsBook.BORROW_BOOK.getValue() + " - Borrow a book ");
        	System.out.println(UserActionsBook.RETURN_BOOK.getValue() + " - Return a book ");
        	System.out.println(UserActionsBook.EXIT.getValue() + " - Exit");

            // ask user answer
            answer = scan.nextLine();

            if (UserActionsBook.containsAction(answer)) {
                rightAnswer = true;
            }
        } while (!rightAnswer);

        return answer;
    }
	
	private void addBookToList() {

		System.out.println("");
		System.out.println("Entrez l'id du livre : ");
		String idLivre = scan.nextLine();
		Integer id = Integer.valueOf(idLivre);
		
		System.out.println("Entrez le titre du livre : ");
		String title = scan.nextLine();
		
		System.out.println("Entrez la description du livre : ");
		String description = scan.nextLine();
		
		System.out.println("Entrez la date de publication du livre au format année-mois-jour ");
		String date = scan.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String text = date.formatted(formatter);
		LocalDate releaseDate = LocalDate.parse(text, formatter);

		// Create new book
		Book newBook = new Book(id, title, description, releaseDate, null, false);
		
		// Get book list
		List<Book> books = bookMethods.returnBookList();
		
		//Boolean test = bookMethods.checkIfBookIsInTheList(newBook, books);

		// check if book title is already in the list and add book to the list
		if (!books.contains(newBook)) {
		books.add(newBook);

		bookMethods.updateList(books);

		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("Livre ajouté ");
		System.out.println("");
		} else { // In case book is already in the list
			System.out.println("");
			System.out.println("---------------------------------");
			System.out.println("Ce livre est déjà dans la liste ");
			System.out.println("");}
	}

	private void deleteBookFromList() {

		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("Livres de la liste ");
		bookMethods.printBookList();

		System.out.println("");
		System.out.println("Entrez un titre de livre que vous souhaitez retirer de la liste s'il en fait déjà partie");
		String title = scan.nextLine();

		List<Book> books = bookMethods.returnBookList();

		Book bookToDelete = new Book(title);
		
		if (!books.contains(bookToDelete)) {
			System.out.println("Ce livre n'est pas dans la liste ");
		} else {
			books.remove(bookToDelete);
			System.out.println("");
			System.out.println("---------------------------------");
			System.out.println("Livre retiré ");
			bookMethods.updateList(books);
		}
	}

	
	
	private void borrowBook() {
		
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("Livres à l'emprunt ");
		bookMethods.printAvailableBookList();
		
		System.out.println("");
		System.out.println("Quel est votre nom ?");
		String name = scan.nextLine();

		System.out.println("");
		System.out.println("Entrez le titre du livre que vous souhaitez emprunter");
		String title = scan.nextLine();
		
		Book bookToLoan = new Book();
		List<Book> books = bookMethods.returnAvailableBookList();
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				bookToLoan = b;
			}
		}
		if (!books.contains(bookToLoan)) {
			System.out.println("Ce livre n'est pas disponible ");
		} else {
			bookToLoan.setIsBorrowed(true);
			Loan updatedLoan = new Loan(name, LocalDate.now(), null);
			bookToLoan.setLoan(updatedLoan);
			System.out.println("");
			System.out.println("---------------------------------");
			System.out.println("Livre empruté ");
			bookMethods.updateList(books);
		}
		
	}
	
	private void returnBook() {

		System.out.println("");
		System.out.println("Entrez le titre du livre que vous souhaitez retourner");
		String title = scan.nextLine();

		List<Book> books = bookMethods.returnBookList();
		Book bookToReturn = new Book();
		
		for (Book b : books) {
			System.out.println(b);
			if (b.getTitle().equals(title)) {
				bookToReturn = b;
			}
		}
		if (!books.contains(bookToReturn)) {
			System.out.println("Ce livre ne vient pas de notre bibliothèque ! ");
		} else {
		bookToReturn.setIsBorrowed(false);
		Loan updatedLoan = bookToReturn.getLoan();
		updatedLoan.setReturnDate(LocalDate.now());
		bookToReturn.setLoan(updatedLoan);
		
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("Livre retourné ");
		bookMethods.updateList(books);
		}

	}
	
	private void checkBorrowedBooks() {
		
	}
	
	private void printBookList() {
		bookMethods.printBookList();
		System.out.println("");
	}

}
