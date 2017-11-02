import java.util.Comparator;

/**
 * 
 * @author Minghao Shan
 *
 */
public class CompareName implements Comparator{
	public int compare(Object obj1, Object obj2) {
		Person p1 = (Person) obj1;
		Person p2 = (Person) obj2;
		return(p1.getName().compareTo(p2.getName()));
	}

}
