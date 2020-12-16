package membersApp;

import java.util.Comparator;

public class MemberLastNameComparator implements Comparator<Member>{
	

	@Override
	public int compare(Member m1, Member m2) {
		
		return m1.getLastName().compareTo(m2.getLastName());
	}

}
