package library;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Book implements Serializable{
	private Integer id;
	private String title;
	private String description;
	private LocalDate releaseDate;
	private ArrayList<Loan> loanHistory;
	private Boolean isBorrowed;
	
	public Book() {
		
	}



	public ArrayList<Loan> getLoanHistory() {
		return loanHistory;
	}



	public void setLoanHistory(ArrayList<Loan> loanHistory) {
		this.loanHistory = loanHistory;
	}



	public Book(Integer id, String title, String description, LocalDate releaseDate, Boolean isBorrowed) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.isBorrowed = isBorrowed;
	}



	public Book(Integer id, String title, String description, LocalDate releaseDate, ArrayList<Loan> loanHistory,
			 Boolean isBorrowed) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.loanHistory = new ArrayList<>();
		this.isBorrowed = isBorrowed;
	}



	public Book(String title) {
		this.title = title;
	}


	public void addLoan(Loan loan) {
		checkLoanInstantiation();
		
		this.loanHistory.add(loan);
	}
	
	public void checkLoanInstantiation() {
		if(this.loanHistory == null) {
			this.loanHistory = new ArrayList<>();
		}
	}

	



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id= " + id + ", title= " + title + ", description= " + description + ", releaseDate= " + releaseDate
				+ ", isBorrowed= " + isBorrowed + "]\n");
				
		builder.append("loanHistory= [");
		
		for(Loan loan : this.loanHistory) {
			builder.append(loan).append("\n").append("              ");
		}
		
		return builder.toString();
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





	public Boolean getIsBorrowed() {
		return isBorrowed;
	}



	public void setId(Integer id) {
		this.id = id;
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
