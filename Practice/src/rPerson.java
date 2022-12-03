import java.util.ArrayList;
public class rPerson {
    private String name;
    private String gender;
    private int age;
    private ArrayList<String> hobbies = new ArrayList<String>();
    public rPerson(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        if(age < 10) {
            System.out.printf("%s 은 미취학 아동입니다! \n", this.name);
            this.age = age;
        }else if(age >= 10 && age < 20) {
            System.out.printf("%s 은 청소년입니다! \n", this.name);
        }else {
            System.out.printf("%s은 성인입니다! \n", this.name);
        }
    }

    public void Birth() {
        System.out.printf("%d살의 %s가 탄생했습니다!", this.age, this.name);
    }

    public void Aging() {
        System.out.printf("%s이 1살 더 먹었습니다! \n", this.name);
        this.age++;
    }

    public void addHobby(String hobby) {
        System.out.printf("%s는 이제 %s가 취미가 되었습니다! \n", this.name, hobby);
        this.hobbies.add(hobby);
    }

    public void addHobbies(String...hobby) {
        for(String item: hobby) {
            this.hobbies.add(item);
        }
        System.out.printf("%s의 취미가 %d개 늘었습니다! \n", this.name, hobby.length);
    }

    public void deleteHobby() {
        this.hobbies.remove(this.hobbies.size()-1);
    }

    public void deleteHobby(String hobby) {
        this.hobbies.remove(hobby);
    }

    public void checkHobbies() {
        if(this.name != null) {
            if (this.hobbies.isEmpty()) {
                System.out.printf("%s는 취미가 없습니다! 취미 하나 만들어보는게 어때요? \n", this.name);
            }else {
                this.hobbies.forEach(h -> System.out.printf("%s의 취미는 %s 입니다! \n", this.name, h));
            }
        }else {
            System.out.printf("이미 죽은 사람입니다! \n");
        }
    }

    public void Death() {
        System.out.printf("%s는 %d살에 죽었습니다! \n", this.name, this.age);
        this.name = null;
        this.gender = null;
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
