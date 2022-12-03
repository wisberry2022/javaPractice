public class Main {
    public static void main(String[] args) {
        rPerson DW = new rPerson("김동원", "male", 5);
        DW.Birth();
        DW.checkHobbies();
        DW.addHobbies("유튜브보기","드럼치기","기타치기");
        DW.checkHobbies();
    }
}