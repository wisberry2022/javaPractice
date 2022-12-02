public class RealizePerson extends Person{
	private String name;
	private String gender;
	private int age = 0;
	
//	@Override
	public void Birth(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	
	
//	@Override
	public void Death() {
		this.name = null;
		this.gender = null;
		this.age = 0;
	}
	
}
