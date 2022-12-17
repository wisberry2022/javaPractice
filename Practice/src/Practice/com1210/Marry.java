package Practice.com1210;

import java.util.Random;
public class Marry {
    private rMother Mother;
    private rFather Father;

    Marry(rMother Mother, rFather Father) {
        this.Mother = Mother;
        this.Father = Father;
        System.out.printf("신랑 %s와 신부 %s가 결혼하였습니다! \n", this.Mother.getName(), this.Father.getName());
    }

    public void tryToBaby(String childName) {
        Random random = new Random();
        boolean isPreg = random.nextBoolean();
        if (isPreg) {
            this.Mother.Pregnancy(childName);
        }else {
            System.out.printf("%s와 %s는 아직 자녀를 가지지 못했습니다!", this.Mother.getName(), this.Father.getName());
        }
    }
}
