import java.util.ArrayList;

public class Person {
	
	private ArrayList<String> words;

	private String name;
	private int age;
	private boolean happy;

	public Person() {
		super();
	}

	public Person(String name, int age, boolean happy) {
		super();
		setName(name);
		this.age = age;
		this.happy = happy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("invalid input for name");
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHappy() {
		return happy;
	}

	public void setHappy(boolean happy) {
		this.happy = happy;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", happy=" + happy + "]";
	}

}
