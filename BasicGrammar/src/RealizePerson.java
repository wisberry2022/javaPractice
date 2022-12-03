import java.util.ArrayList;

public class RealizePerson extends Person{
	private String name;
	private String gender;
	private int age = 0;
	private ArrayList<String> hobbies = new ArrayList<String>();
	
	
//	@Override
	public void Birth(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public void addHobby(String...hobby) {
		for(int i = 0; i<hobby.length; i++) {
			System.out.println(hobby[i]);
		}
	}
	
//	@Override
	public void Death() {
		this.name = null;
		this.gender = null;
		this.age = 0;
	}
	
}
