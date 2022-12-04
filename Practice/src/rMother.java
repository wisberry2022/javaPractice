import java.util.Random;

class Embryo extends Baby {
    Embryo(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public String getGender() {
        return super.gender;
    }

    @Override
    public void Death() {
        super.Extinction();
    }
}

public class rMother extends Mother{
    private String[] genderSet = {"male", "female"};
    private Embryo Baby;
    rMother(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void Pregnancy(String babyName) {
        Random random = new Random();
        int genderNum = random.nextInt(2);
        this.Baby = new Embryo(babyName, genderSet[genderNum], 0);
        System.out.printf("%s는 %s를 임신했습니다! %s입니다! \n", super.name, babyName, super.gender);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void Abort() {
        System.out.printf("%s가 유산되었습니다!", super.name);
        Baby.Death();
    }
    @Override
    public void Death() {
        System.out.printf("%s는 %d살에 죽었습니다! \n", super.name, super.age);
    }

}
