package membersApp;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Member implements Serializable{
	
	private Long id;
	private String firstName;
	private String lastName;
	
	public Member() {
		
	}
	
	public Member(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}

	