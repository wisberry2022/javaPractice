package Practice.com1210;

class Phone {
    String name;
    String company;
    String storage = "30GB";
    Phone(String name, String company) {
        this.name = name;
        this.company = company;
        System.out.printf("%s의 %s가 출고되었습니다!", this.company, this.name);
    }
}

class iPhone extends Phone {
    iPhone(String name, String company) {
        super(name, company);
    }


    public String getName() {
        return this.name;
    }

    public String getStorage() {
        return this.storage;
    }

    public void showProduct() {
        System.out.printf("%s %s \n", this.company, this.name);
    }
}

public class Etd {
    public static void main(String[] args) {
        iPhone S1 = new iPhone("아이폰", "애플");
        System.out.println(S1.getStorage());

    }
}
