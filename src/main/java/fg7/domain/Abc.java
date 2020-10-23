package fg7.domain;

public class Abc {

	private String firstName;
	private String lastName;
	private int age;

	public Abc(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}
}
