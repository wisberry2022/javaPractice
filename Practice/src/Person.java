public abstract class Person {
    String name;
    String gender;
    int age;
    Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        if(age < 10) {
            if(age == 0) {
                System.out.printf("%s는 태아입니다! \n", this.name);
            }else {
                System.out.printf("%s 은 미취학 아동입니다! \n", this.name);
            }
            this.age = age;
        }else if(age >= 10 && age < 20) {
            System.out.printf("%s 은 청소년입니다! \n", this.name);
            this.age = age;
        }else {
            System.out.printf("%s은 성인입니다! \n", this.name);
            this.age = age;
        }
    };
    public abstract void Death();

    protected void Extinction() {
        this.name = null;
        this.gender = null;
        this.age = 0;
    }
}

abstract class Mother extends Person {
    Mother(String name, String gender, int age) {
        super(name, gender, age);
    }
    public abstract void Pregnancy(String baby);
    public abstract String getName();
    public abstract void Abort();
    public abstract void Death();
}

abstract class Father extends Person {
    Father(String name, String gender, int age) {
        super(name, gender, age);
    }

    public abstract String getName();
    public abstract void Death();
}

abstract class Baby extends Person {
    Baby(String name, String gender, int age) {
        super(name, gender, age);
    }

    public abstract String getGender();
}