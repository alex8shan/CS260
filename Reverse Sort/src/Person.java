
public class Person implements Comparable{
	int age;
	String name;
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	/**
	 * compares the age
	 */
	public int compareTo(Object obj) {
		int age;
		Person p = (Person)obj;
		if(this.getAge() == p.getAge()) {
			return 0;
		} else {
			return(this.getAge() - p.getAge());
		}
	}
	
	public String toString() {
		return "Name: " + name + "; Age: " + age;
	}
}
