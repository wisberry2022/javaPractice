package Practice.com1210;

import java.util.ArrayList;
public class rPerson extends Person {
    private ArrayList<String> hobbies = new ArrayList<String>();

    rPerson(String name, String gender, int age) {
        super(name, gender, age);
    }

    public void Birth() {
        System.out.printf("%d살의 %s가 탄생했습니다! \n", super.age, super.name);
    }

    public void Aging() {
        System.out.printf("%s이 1살 더 먹었습니다! \n", super.name);
        super.age++;
    }

    public void addHobby(String hobby) {
        System.out.printf("%s는 이제 %s가 취미가 되었습니다! \n", super.name, hobby);
        this.hobbies.add(hobby);
    }

    public void addHobbies(String...hobby) {
        for(String item: hobby) {
            this.hobbies.add(item);
        }
        System.out.printf("%s의 취미가 %d개 늘었습니다! \n", super.name, hobby.length);
    }

    public void deleteHobby() {
        this.hobbies.remove(this.hobbies.size()-1);
    }

    public void deleteHobby(String hobby) {
        this.hobbies.remove(hobby);
    }

    public void checkHobbies() {
        if(super.name != null) {
            if (this.hobbies.isEmpty()) {
                System.out.printf("%s는 취미가 없습니다! 취미 하나 만들어보는게 어때요? \n", super.name);
            }else {
                this.hobbies.forEach(h -> System.out.printf("%s의 취미는 %s 입니다! \n", super.name, h));
            }
        }else {
            System.out.printf("이미 죽은 사람입니다! \n");
        }
    }

    @Override
    public void Death() {
        super.Extinction();
        System.out.printf("%s는 %d살에 죽었습니다! \n", super.name, super.age);
    }

    public String getName() {
        return super.name;
    }

    public String getGender() {
        return super.gender;
    }

    public int getAge() {
        return super.age;
    }
}
