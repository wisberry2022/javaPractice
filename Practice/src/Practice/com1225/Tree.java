package Practice.com1225;

import java.util.*;



class Student implements Comparable {
    String id;
    int ml,eng,math;
    double avg;
    public Student(String id, int ml, int eng, int math){
        this.id = id;
        this.ml = ml;
        this.eng = eng;
        this.math = math;
        this.getAvg();
    }

    private void getAvg() {
        this.avg = (int)((ml+eng+math)*100/3.0)*0.01;
    }

//    @Override
//    public int compareTo(Object o) {
//        return Integer.parseInt(this.id) - Integer.parseInt(((Student)(o)).id);
//    }

    // 성적 순 정렬
    @Override
    public int compareTo(Object o) {
        return (int)(((Student)(o)).avg) - (int)(this.avg);
    }


}

public class Tree {
    public static void main(String[] args) {
        Student std1 = new Student("1", 90, 79, 100);
        Student std2 = new Student("2", 79, 76, 75);
        Student std3 = new Student("3", 65, 82, 71);
        Student std4 = new Student("4", 100, 100, 97);
        Student std5 = new Student("5", 81, 83, 77);

        Set<Student> test = new TreeSet<>();

        test.add(std1);
        test.add(std2);
        test.add(std3);
        test.add(std4);
        test.add(std5);

        Iterator<Student> ite = test.iterator();
        System.out.println("-------------------------------------------------");
        while(ite.hasNext()){
            Student stu = ite.next();
            System.out.println(stu.id + "\t" + stu.ml + "\t" + stu.eng + "\t" + stu.math + "\t" + stu.avg);
        }
        System.out.println("-------------------------------------------------");

    }
}
