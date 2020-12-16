package library;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable{
	
	private String name;
	private LocalDate loanDate;
	private LocalDate returnDate;
	
	public Loan() {
		
	}
	
	public Loan(String name, LocalDate loanDate, LocalDate returnDate) {
		this.name = name;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}
	
	public Loan(String name, LocalDate loanDate) {
		this.name = name;
		this.loanDate = loanDate;
	}
	
	public Loan(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Loan [borrower= " + name + ", loanDate= " + loanDate + ", returnDate= " + returnDate + "]";
	}

	public String getName() {
		return name;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	

}
