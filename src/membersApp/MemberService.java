package membersApp;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MemberService {
	
	public MemberService() {
		run();
	}
	
	private void run() {
		System.out.println("MemberService Start");
		System.out.println("----------------------------------------------");
		System.out.println("");
		
		List<Member> members = new LinkedList();
		members = createList();
		
		Collections.sort(members, new MemberIdComparator());
		printList(members);
		
		Collections.sort(members, new MemberFirstNameComparator());
		printList(members);
		
		Collections.sort(members, new MemberLastNameComparator());
		printList(members);
		
	}
	
	public List<Member> createList(){
		Member member1 = new Member(1L, "Michel", "Durand");
		Member member2 = new Member(2L, "Toto", "Tata");
		Member member3 = new Member(3L, "Jeanine", "Delaconta");
		Member member4 = new Member(4L, "Renault", "Ahahaha");
		
		/* Méthode rapide pour créer une liste, mais attention, l'Arrays.asList n'est pas modifiable
		 * Besoin de la repasser dans une LinkedList ou une ArrayList pour pouvoir travailler dessus
		 */
		
		List<Member> members = new LinkedList<>(Arrays.asList(member1, member2, member3, member4));
		
		printList(members);
		
		return members;
	}
	
	public void printList(List<Member> members) {
		System.out.println("");
		for (Member m : members) {
			System.out.println(m);
		}
		System.out.println("----------------------------------------------");
	}

}
