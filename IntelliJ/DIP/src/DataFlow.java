import java.util.Scanner;

public class DataFlow {

    public static void main(String[] args) {
        DataController dc = new DataController(new Datas().getData());

        System.out.println("----------Data Flow-------------");

        int num1 = dc.getData(2);
        int num2 = dc.getData(0);
        int num3 = dc.getData(3);

        int num4 = dc.getData(4);
        int num5 = dc.getData(5);

        if(dc.getData(2) == 2) {
            System.out.println("hello data");
            //....
        }

    }
}
