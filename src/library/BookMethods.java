package library;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookMethods implements Serializable{
	
	private Book book;
	private String currentPath;
	
	public BookMethods() {
		currentPath = "/Users/rodolphebossin/Documents/Humanbooster/Cours/tests Java/Library/Books/books.rtf";
	}
	
	public List<Book> returnBookList() {

		ArrayList<Book> books = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(currentPath);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			books = (ArrayList<Book>) ois.readObject();

		} catch (EOFException e) {
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return books;

	}
	
	public void printAvailableBookList(){
		
		List<Book> availableBooks = returnAvailableBookList();
		if (!availableBooks.isEmpty()) {
			for (Book book : availableBooks) {
				System.out.println(/* counter + " - " + */ book.toString());
				//counter++;
			}
		} else {
			System.out.println("Aucun livre dans cette liste ");
		}
		
	}
	
	public List<Book> returnAvailableBookList() {
		
		List<Book> books = returnBookList();
		for( Book b : returnBookList()) {
			if(b.getIsBorrowed() == false) {
				books.add(b);
			}
		}
		List<Book>  availableBooks = books;
		return availableBooks;
	}
	
	public void printBookList() {

		List<Book> books = returnBookList();
		// int counter = 0;

		if (!books.isEmpty()) {
			for (Book book : books) {
				System.out.println(/* counter + " - " + */ book.toString());
				//counter++;
			}
		} else {
			System.out.println("Aucun livre dans cette liste ");
		}
	}
	
	
	public void updateList(List<Book> books) {
		
		try (FileOutputStream fos = new FileOutputStream(currentPath);
				ObjectOutputStream oop = new ObjectOutputStream(fos)){
			
			oop.writeObject(books);
			oop.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* public Boolean checkIfBookIsInTheList(Book book, List<Book> books) {

		Boolean test = false;

		while (test == false) {
			for (Book b : books) {
				test = b.equals(book);
			}
		}
		return test;

	} */
	
	public void createBookList() {
		ArrayList<Book> bookList = new ArrayList<>();
	}

}
