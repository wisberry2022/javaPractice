package Practice.com1217;

class DataArray {
    private Student[] stdArr = new Student[0];
    void add(Student std) {
        Student[] copyArr = new Student[stdArr.length+1];
        for(int i = 0; i<stdArr.length; i++) {
            copyArr[i] = stdArr[i];
        }
        copyArr[copyArr.length-1] = std;
        stdArr = copyArr;
    }

    void RemoveItem(String id) {
        Student[] copyArr = new Student[stdArr.length-1];
        boolean notRemove = true;
        for(int i = 0; i<copyArr.length; i++) {
            if(stdArr[i].getID().equals(id)) {
                copyArr[i] = stdArr[i+1];
                notRemove = false;
                continue;
            }else {
                if(notRemove) {
                    copyArr[i] = stdArr[i];
                }else {
                    copyArr[i] = stdArr[i+1];
                }

            }
        }
        stdArr = copyArr;
    }

    Student[] getArr() {
        return this.stdArr;
    }
}

class Student {
    private String id;
    private int java;
    private int web;
    private int framework;
    private int sum;
    private String grade;
    double average;

    public Student(String id, int java, int web, int framework) {
        this.id = id;
        this.java = java;
        this.web = web;
        this.framework = framework;
    }

    public String getID() {
        return this.id;
    }

    public int getJava() {
        return this.java;
    }

    public int getWeb() {
        return this.web;
    }

    public int getFW() {
        return this.framework;
    }

    public int getSum() {
        return this.sum;
    }

    public double getAverage() {
        return this.average;
    }

    public String getGrade() {
        return this.grade;
    }

    public void sum() {
        this.sum = this.java + this.web + this.framework;
    }

    public void average() {
        average = (int)((sum*100) / 3.0)*0.01;
    }

    public void calcGrade() {
        int criteria = (int)average / 10;
        if(9 <= criteria && criteria <= 10) {
            grade = "A";
        }else if(8 <= criteria && criteria <9) {
            grade = "B";
        }else if(7 <= criteria && criteria <8) {
            grade = "C";
        }else if(6 <= criteria && criteria <7) {
            grade = "D";
        }else {
            grade = "F(????????? ??????)";
        }
    }
}

public class GradeManagement {
    private static DataArray stdArr = new DataArray();

    public static void List() {
        Student[] listData = stdArr.getArr();
        System.out.println("\n============================?????????============================\n");
        System.out.println("??????\t\t\t\tjava\tweb\t\tframework");
        for(int i = 0; i<listData.length; i++) {
            System.out.println(listData[i].getID() + "\t\t" + listData[i].getJava() + "\t\t" + listData[i].getWeb() + "\t\t" + listData[i].getFW());
        }
        System.out.println("\n=============================================================\n");
    }

    public static void InputData() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("????????? ???????????????!>");
        String id = sc.nextLine();

        System.out.print("java ????????? ???????????????!>");
        int java = sc.nextInt();

        System.out.print("web ????????? ???????????????!>");
        int web = sc.nextInt();

        System.out.print("framework ????????? ???????????????!>");
        int fr = sc.nextInt();
        Student std = new Student(id, java, web, fr);
        std.sum();
        std.average();
        std.calcGrade();
        stdArr.add(std);
    }

    public static void DetailList() {
        Student[] listData = stdArr.getArr();
        System.out.println("\n============================????????????============================\n");
        System.out.println("??????\t\t\t\t????????????\t????????????\t\t??????");
        for(int i = 0; i<listData.length; i++) {
            System.out.println(listData[i].getID() + "\t\t" + listData[i].getSum() + "\t\t" + listData[i].getAverage() + "\t\t" + listData[i].getGrade());
        }
        System.out.println("\n=============================================================\n");
    }

    public static void RemoveList() {
        boolean notRemove = true;
        Student[] listData = stdArr.getArr();
        String[] idSet = new String[listData.length];
        for(int i = 0; i<idSet.length; i++) {
            idSet[i] = listData[i].getID();
            System.out.println(idSet[i]);
        }

        if(listData.length == 0) {
            System.out.println("????????? ????????? ????????????!");
            return;
        }else {
            System.out.println("???????????? ????????? ?????????????????????! ????????? ???????????? ?????? ????????? ??????????????? ????????? ??? ????????????!");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            while(notRemove) {
                System.out.print(">");
                String id = sc.nextLine();
                for(int i = 0; i<idSet.length; i++) {
                    if(idSet[i].equals(id)) {
                        stdArr.RemoveItem(id);
                        notRemove = false;
                    }
                }
                if(notRemove) {
                    System.out.println("????????? ????????? ????????????! ????????? ????????? ?????? ??? ??? ??????????????????!");
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("?????????????????????????????? (0.2.0)");

        while(true){
            System.out.println("1.?????????    2.??????    3.????????????    4.??????    0.?????? >");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int select = sc.nextInt();

            if(select == 0){
                System.out.println("?????????????????????????????? ??????");
                return;
            }else if(select == 1){
                List();
            }else if(select == 2){
                InputData();
            }else if(select == 3){
                DetailList();
            }else if(select == 4){
                RemoveList();
            }else {
                System.out.println("????????? ????????? ????????????! ?????? ??????????????????!");
            }
        }
    }
}
