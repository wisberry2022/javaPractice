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
            grade = "F(재수강 요망)";
        }
    }
}

public class GradeManagement {
    private static DataArray stdArr = new DataArray();

    public static void List() {
        Student[] listData = stdArr.getArr();
        System.out.println("\n============================리스트============================\n");
        System.out.println("학번\t\t\t\tjava\tweb\t\tframework");
        for(int i = 0; i<listData.length; i++) {
            System.out.println(listData[i].getID() + "\t\t" + listData[i].getJava() + "\t\t" + listData[i].getWeb() + "\t\t" + listData[i].getFW());
        }
        System.out.println("\n=============================================================\n");
    }

    public static void InputData() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("학번을 입력하세요!>");
        String id = sc.nextLine();

        System.out.print("java 점수를 입력하세요!>");
        int java = sc.nextInt();

        System.out.print("web 점수를 입력하세요!>");
        int web = sc.nextInt();

        System.out.print("framework 점수를 입력하세요!>");
        int fr = sc.nextInt();
        Student std = new Student(id, java, web, fr);
        std.sum();
        std.average();
        std.calcGrade();
        stdArr.add(std);
    }

    public static void DetailList() {
        Student[] listData = stdArr.getArr();
        System.out.println("\n============================상세보기============================\n");
        System.out.println("학번\t\t\t\t점수합계\t점수평균\t\t학점");
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
            System.out.println("등록된 정보가 없습니다!");
            return;
        }else {
            System.out.println("시스템에 등록된 학번목록입니다! 학번을 입력하면 해당 학생의 성적정보를 삭제할 수 있습니다!");
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
                    System.out.println("등록된 학번이 아닙니다! 입력한 학번을 다시 한 번 확인해주세요!");
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("학생성적관리프로그램 (0.2.0)");

        while(true){
            System.out.println("1.리스트    2.입력    3.상세보기    4.삭제    0.종료 >");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int select = sc.nextInt();

            if(select == 0){
                System.out.println("학생성적관리프로그램 종료");
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
                System.out.println("올바른 입력이 아닙니다! 다시 확인해주세요!");
            }
        }
    }
}
