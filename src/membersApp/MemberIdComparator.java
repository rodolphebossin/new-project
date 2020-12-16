package membersApp;

import java.util.Comparator;

public class MemberIdComparator implements Comparator<Member> {
	
	@Override
	public int compare(Member m1, Member m2) {
		
		return m1.getFirstName().compareTo(m2.getFirstName());
	}

}
