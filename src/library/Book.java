package library;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{
	private Integer id;
	private String title;
	private String description;
	private LocalDate releaseDate;
	private Loan loan;
	private Boolean isBorrowed;
	
	public Book() {
		
	}



	public Book(Integer id, String title, String description, LocalDate releaseDate, Loan loan, Boolean isBorrowed) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.loan = loan;
		this.isBorrowed = isBorrowed;
	}
	
	public Book(Integer id, String title, String description, LocalDate releaseDate, String name, LocalDate loanDate, LocalDate returnDate, Boolean isBorrowed) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.loan = new Loan(name, releaseDate, returnDate);
		this.isBorrowed = isBorrowed;
	}



	public Book(String title) {
		this.title = title;
	}




	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", loan=" + loan + ", isBorrowed=" + isBorrowed + "]";
	}



	@Override
	// Based on book title
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	public Integer getId() {
		return id;
	}



	public Loan getLoan() {
		return loan;
	}



	public Boolean getIsBorrowed() {
		return isBorrowed;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setLoan(Loan loan) {
		this.loan = loan;
	}



	public void setIsBorrowed(Boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}
