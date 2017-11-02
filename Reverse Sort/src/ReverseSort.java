import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a side project that reverse the sort of a array.
 * @author Minghao Shan
 *
 */
public class ReverseSort {
	public static void main (String args[]) {
		Person thong = new Person(19,"Thong");
		Person hieu = new Person(23, "Hieu");
		Person pasindu = new Person(17,"Pasindu");
		Person tahj = new Person(20,"Tahj");
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(thong);
		personList.add(hieu);
		personList.add(pasindu);
		personList.add(tahj);
		
		System.out.println("Original order:");
		
		for(Person p : personList) {
			System.out.println(p.toString());
		}
		
		Collections.sort(personList, new CompareName());
		
		System.out.println("\nAfter the name is sorted:");
		
		for(Person p : personList) {
			System.out.println(p.toString());
		}
		
		Collections.sort(personList);
		
		System.out.println("\nAfter the age is sorted:");
		
		for(Person p : personList) {
			System.out.println(p.toString());
		}
	}
}
