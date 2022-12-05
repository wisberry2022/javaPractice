public class Main {
    public static void main(String[] args) {
        rMother Mother = new rMother("김태희", "female", 30);
        rFather Father = new rFather("정지훈", "male", 32);
        Marry Marriage = new Marry(Mother, Father);
        Marriage.tryToBaby("김지훈");
    }
}
