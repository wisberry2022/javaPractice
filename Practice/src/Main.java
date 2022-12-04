public class Main {
    public static void main(String[] args) {
        rMother Mother = new rMother("김민화", "female", 30);
        rFather Father = new rFather("박지훈", "male", 34);
        Marry Marriage = new Marry(Mother, Father);
        Marriage.tryToBaby("박서준");
    }
}